package ExceptionalHandlings;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter two numbers:");
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println("Result: " + (x / y));
        } catch (Exception e) {
            System.out.println("Exception handled: " + e.getMessage());
        } finally {
            scan.close();
            System.out.println("Scanner closed in finally block.");
        }
    }
}
