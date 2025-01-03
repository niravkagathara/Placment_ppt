import java.util.Stack;

public class p79 {
    
    // Function to check if a character is an operator
    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    // Function to get the precedence of operators
    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    // Function to convert infix expression to postfix expression
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            
            // If the character is an operand, append it to the postfix expression
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } 
            // If the character is '(', push it onto the stack
            else if (c == '(') {
                stack.push(c);
            } 
            // If the character is ')', pop from the stack until '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();  // Pop '(' from the stack
            } 
            // If the character is an operator, process according to precedence
            else if (isOperator(c)) {
                while (!stack.isEmpty() && isOperator(stack.peek()) &&
                        getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);  // Push the current operator onto the stack
            }
        }
        
        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix = "(A + B) * (C + D)";
        String postfix = infixToPostfix(infix);
        System.out.println("Infix Expression: " + infix);
        System.out.println("Postfix Expression: " + postfix);
    }
}
