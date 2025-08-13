package Calculator;
import java.util.*;

public class Operation {
    double operand1;
    double operand2;
    char operator;
    double result;

    Operation(double operand1, double operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.result = calculate();
    }

    double calculate() {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    System.out.println("Error: Division by zero!");
                    return Double.NaN;
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}

