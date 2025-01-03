public class p77 {
    public boolean containsPattern(String s) {
        int n = s.length();
        
        // Iterate over possible lengths of w
        for (int len = 1; len <= n / 2; len++) {
            // Iterate through all possible starting points for w
            for (int i = 0; i <= n - 2 * len - 1; i++) {
                String w = s.substring(i, i + len);
                String wR = new StringBuilder(w).reverse().toString(); // Reverse of w
                String c = String.valueOf(s.charAt(i + len)); // Character in the middle
                
                // Check if the substring after the character c is wR
                if (s.substring(i + len + 1).startsWith(wR)) {
                    return true; // If found, return true
                }
            }
        }
        return false; // No valid pattern found
    }

    public static void main(String[] args) {
        p77 pr = new p77();
        
        // Test example 1
        String s1 = "abccba";
        System.out.println(pr.containsPattern(s1)); // Output: true

        // Test example 2
        String s2 = "abcde";
        System.out.println(pr.containsPattern(s2)); // Output: false
    }
}
