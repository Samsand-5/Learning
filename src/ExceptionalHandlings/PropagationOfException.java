package ExceptionalHandlings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PropagationOfException {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter two numbers");
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println(x/y);
        }
        catch(ArithmeticException e) {
            System.out.println("ArithmeticException handled");
        }
        catch(InputMismatchException e) {
            System.out.println("InputMismatchException handled");
        }

        try {
            scan.nextLine();
            int[] arr = {1,2,3,4,5};
            System.out.println("Enter the index to access");
            System.out.println(arr[scan.nextInt()]);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled");
        }

        try {
            Class.forName("Demo");
        }
        catch(Exception e) {
            System.out.println("ClassNotFoundException handled");
        }
    }

}
