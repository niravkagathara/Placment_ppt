public class p73 {

    public int countWaysToSelectBuildings(String s) {
        int n = s.length();
        int count = 0;

        // Loop through each pair of buildings to find valid triplets
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                // Ensure no two consecutive buildings have the same type
                if (s.charAt(i) != s.charAt(j)) {
                    for (int k = j + 1; k < n; k++) {
                        if (s.charAt(j) != s.charAt(k)) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        p73 solution = new p73();
        String s = "001101";
        int result = solution.countWaysToSelectBuildings(s);
        System.out.println("Number of valid ways to select buildings: " + result);  // Output: 6
    }
}
