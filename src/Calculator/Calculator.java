package Calculator;
import java.util.*;

public class Calculator {
    private static final int HISTORY_LIMIT = 5;
    private final LinkedList<Operation> history = new LinkedList<>();

    public void addOperation(double op1, double op2, char operator) {
        Operation newOp = new Operation(op1, op2, operator);
        if (history.size() == HISTORY_LIMIT) {
            history.removeFirst(); // Remove oldest
        }
        history.add(newOp);
        System.out.println("Result: " + newOp.result);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No history available.");
            return;
        }
        System.out.println("\n--- Last " + history.size() + " Operations ---");
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ": " + history.get(i));
        }
    }

    public void modifyOperation(int index, double newOp1, double newOp2, char newOperator) {
        if (index < 1 || index > history.size()) {
            System.out.println("Invalid index.");
            return;
        }
        Operation modified = new Operation(newOp1, newOp2, newOperator);
        history.set(index - 1, modified);
        System.out.println("Updated Operation: " + modified);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nCalculator Menu:");
            System.out.println("1. Add Operation");
            System.out.println("2. Show History");
            System.out.println("3. Modify Operation");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    double op1 = sc.nextDouble();
                    System.out.print("Enter operator (+ - * /): ");
                    char operator = sc.next().charAt(0);
                    System.out.print("Enter second number: ");
                    double op2 = sc.nextDouble();
                    calc.addOperation(op1, op2, operator);
                    break;

                case 2:
                    calc.showHistory();
                    break;

                case 3:
                    calc.showHistory();
                    if (!calc.history.isEmpty()) {
                        System.out.print("Enter operation number to modify: ");
                        int index = sc.nextInt();
                        System.out.print("Enter new first number: ");
                        double newOp1 = sc.nextDouble();
                        System.out.print("Enter new operator (+ - * /): ");
                        char newOperator = sc.next().charAt(0);
                        System.out.print("Enter new second number: ");
                        double newOp2 = sc.nextDouble();
                        calc.modifyOperation(index, newOp1, newOp2, newOperator);
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}