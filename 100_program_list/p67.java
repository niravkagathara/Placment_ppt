// Given a string s which represents an expression, evaluate this expression and return its
// value. Value should be taken from the user.
import java.util.Stack;

public class p67 {
    public static int evaluateExpression(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int operator = 1;  // 1 means positive, -1 means negative
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the character is a digit, accumulate the number
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // If the character is an operator or we're at the end of the string
            if (c == '+' || c == '-' || c == '(' || c == ')' || i == s.length() - 1) {
                if (c == '+' || c == '-') {
                    // Push the number with the current operator
                    result += operator * num;
                    num = 0;  // Reset num
                    operator = (c == '+') ? 1 : -1;  // Update operator to +1 or -1
                } else if (c == '(') {
                    // Push the result and operator on the stack to handle parentheses
                    stack.push(result);
                    stack.push(operator);
                    result = 0;
                    operator = 1;  // Reset the operator for the next expression inside parentheses
                } else if (c == ')') {
                    // Calculate result inside parentheses
                    result += operator * num;
                    num = 0;
                    result *= stack.pop();  // Pop the operator for the sub-expression
                    result += stack.pop();  // Pop the previous result before '('
                }
            }

            // If we're at the end of the string, add the last accumulated number
            if (i == s.length() - 1 && c != ')') {
                result += operator * num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Take the input from the user
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a mathematical expression: ");
        String expression = scanner.nextLine();
        int result = evaluateExpression(expression);
        System.out.println("The result of the expression is: " + result);
    }
}
