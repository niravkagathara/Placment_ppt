import java.util.Stack;

public class p78 {
    // Function to evaluate prefix expression
    public static int evaluatePrefix(String expression) {
        // Create a stack to hold values
        Stack<Integer> stack = new Stack<>();
        
        // Reverse the prefix expression (process from right to left)
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            
            // Skip spaces in the expression
            if (ch == ' ') {
                continue;
            }
            
            // If the character is a digit, extract the full number and push it to the stack
            if (Character.isDigit(ch)) {
                int num = 0;
                // Handle multiple digits in the operand
                while (i >= 0 && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i--;
                }
                i++; // Adjust for the extra decrement in the while loop
                stack.push(num);
            }
            // If the character is an operator, pop two elements and apply the operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid prefix expression.");
                }
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                
                switch (ch) {
                    case '+': 
                        stack.push(operand1 + operand2); 
                        break;
                    case '-': 
                        stack.push(operand1 - operand2); 
                        break;
                    case '*': 
                        stack.push(operand1 * operand2); 
                        break;
                    case '/': 
                        stack.push(operand1 / operand2); 
                        break;
                    default: 
                        throw new IllegalArgumentException("Unknown operator encountered.");
                }
            }
        }
        
        // The result will be the top of the stack
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid prefix expression.");
        }
        
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String prefixExpression = "* - + 5 5 * 10 2 5"; // Example prefix expression
        
        try {
            int result = evaluatePrefix(prefixExpression);
            System.out.println("Result of the Prefix Expression: " + result);  // Output: 25
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
