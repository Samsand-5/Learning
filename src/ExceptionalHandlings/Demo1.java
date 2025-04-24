package ExceptionalHandlings;

import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println("Enter two numbers");
        try(Scanner scan = new Scanner(System.in)) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println(x/y);
        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Exception handled");
        }
        finally {
            System.out.println("finally block");
        }
    }
}
