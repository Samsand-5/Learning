package MultiThreading.Locks;

import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {
    private static final ReentrantLock lock = new ReentrantLock(true); // fairness = true

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            final int threadId = i;
            new Thread(() -> accessResource(threadId)).start();
        }
    }

    private static void accessResource(int threadId) {
        System.out.println("Thread " + threadId + " is waiting to acquire the lock...");
        lock.lock();
        try {
            System.out.println("Thread " + threadId + " has acquired the lock.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadId + " cannot aquire the lock.");
            }
        } finally {
            System.out.println("Thread " + threadId + " is releasing the lock.");
            lock.unlock();
        }
    }
}
