package MultiThreadingPractice.ThroughPut;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ApiThroughputTester {

    private static CompletableFuture<Long> makeRequest(HttpClient client, String url) {
        long start = System.nanoTime();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .timeout(Duration.ofSeconds(10))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    long latency = System.nanoTime() - start;
                    if (response.statusCode() != 200) {
                        System.err.println("Non-OK status: " + response.statusCode());
                    }
                    return latency;
                })
                .exceptionally(ex -> {
                    System.err.println("Request failed: " + ex.getMessage());
                    return -1L; // mark as failed
                });
    }

    public static void testThroughput(String url, int numberOfRequests, int concurrency, int warmupRequests) {
        ExecutorService executor = Executors.newFixedThreadPool(concurrency);
        HttpClient client = HttpClient.newBuilder()
                .executor(executor)
                .build();

        try {
            // Warm-up phase
            System.out.println("Warming up with " + warmupRequests + " requests...");
            List<CompletableFuture<Long>> warmupFutures = new ArrayList<>();
            for (int i = 0; i < warmupRequests; i++) {
                warmupFutures.add(makeRequest(client, url));
            }
            CompletableFuture.allOf(warmupFutures.toArray(new CompletableFuture[0])).join();
            System.out.println("Warm-up complete.\n");

            // Measurement phase
            List<CompletableFuture<Long>> futures = new ArrayList<>();
            long startTime = System.nanoTime();

            for (int i = 0; i < numberOfRequests; i++) {
                futures.add(makeRequest(client, url));
            }

            List<Long> latencies = futures.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());

            long endTime = System.nanoTime();
            long totalTimeMs = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

            // Filter out failed requests
            List<Long> successfulLatencies = latencies.stream()
                    .filter(l -> l > 0)
                    .collect(Collectors.toList());

            int successCount = successfulLatencies.size();
            int failureCount = numberOfRequests - successCount;

            // Compute stats
            Collections.sort(successfulLatencies);
            double avgLatencyMs = successfulLatencies.stream()
                    .mapToLong(Long::longValue)
                    .average()
                    .orElse(0) / 1_000_000.0;

            long minLatencyMs = successfulLatencies.isEmpty() ? 0 : successfulLatencies.get(0) / 1_000_000;
            long maxLatencyMs = successfulLatencies.isEmpty() ? 0 : successfulLatencies.get(successfulLatencies.size() - 1) / 1_000_000;
            long p95LatencyMs = percentile(successfulLatencies, 95) / 1_000_000;
            long p99LatencyMs = percentile(successfulLatencies, 99) / 1_000_000;

            // Print results
            System.out.println("===== Test Summary =====");
            System.out.println("Total requests: " + numberOfRequests);
            System.out.println("Concurrency: " + concurrency);
            System.out.println("Total time: " + totalTimeMs + " ms");
            System.out.printf("Throughput: %.2f requests/sec%n", numberOfRequests / (totalTimeMs / 1000.0));
            System.out.println("Success: " + successCount);
            System.out.println("Failures: " + failureCount);
            System.out.printf("Latency (ms): min=%d, avg=%.2f, p95=%d, p99=%d, max=%d%n",
                    minLatencyMs, avgLatencyMs, p95LatencyMs, p99LatencyMs, maxLatencyMs);

        } finally {
            executor.shutdown();
        }
    }

    private static long percentile(List<Long> sortedLatencies, double percentile) {
        if (sortedLatencies.isEmpty()) return 0;
        int index = (int) Math.ceil(percentile / 100.0 * sortedLatencies.size()) - 1;
        return sortedLatencies.get(Math.min(index, sortedLatencies.size() - 1));
    }

    public static void main(String[] args) {
        String url = "http://localhost:8080/factorial";
        int numberOfRequests = 100;
        int concurrency = 20;
        int warmupRequests = 10;

        testThroughput(url, numberOfRequests, concurrency, warmupRequests);
    }
}