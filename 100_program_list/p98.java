import java.util.regex.*;

public class p98 {
    public boolean isNumber(String s) {
        // Define the regular expression for a valid number.
        String regex = "^[+-]?((\\d+\\.\\d*)|(\\.\\d+)|(\\d+))([eE][+-]?\\d+)?$";
        
        // Use Pattern and Matcher to match the regular expression
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s.trim());  // trim the input to remove leading/trailing spaces
        
        return matcher.matches();
    }

    public static void main(String[] args) {
        p98 solution = new p98();

        // Test cases
        System.out.println(solution.isNumber("2"));           // true
        System.out.println(solution.isNumber("0089"));        // true
        System.out.println(solution.isNumber("-0.1"));        // true
        System.out.println(solution.isNumber("+3.14"));       // true
        System.out.println(solution.isNumber("4."));          // true
        System.out.println(solution.isNumber("-0.9"));        // true
        System.out.println(solution.isNumber("2e10"));        // true
        System.out.println(solution.isNumber("-90E3"));       // true
        System.out.println(solution.isNumber("3e+7"));       // true
        System.out.println(solution.isNumber("+6e-1"));      // true
        System.out.println(solution.isNumber("53.5e93"));    // true
        System.out.println(solution.isNumber("-123.456e789"));// true

        // Invalid numbers
        System.out.println(solution.isNumber("abc"));         // false
        System.out.println(solution.isNumber("1a"));          // false
        System.out.println(solution.isNumber("1e"));          // false
        System.out.println(solution.isNumber("e3"));          // false
        System.out.println(solution.isNumber("99e2.5"));      // false
        System.out.println(solution.isNumber("--6"));         // false
        System.out.println(solution.isNumber("-+3"));         // false
        System.out.println(solution.isNumber("95a54e53"));    // false
    }
}
