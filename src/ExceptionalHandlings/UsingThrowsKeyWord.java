package ExceptionalHandlings;

public class UsingThrowsKeyWord {
    public static void main(String[] args) {
        try {
            div(10, 2);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General exception: " + e.getMessage());
        }
    }

    public static void div(int x, int y) throws ClassNotFoundException,RuntimeException {
        System.out.println(x / y);
        Class.forName("demo");
    }
}

