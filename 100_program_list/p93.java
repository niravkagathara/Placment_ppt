import java.util.*;

public class p93 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); // Create a HashMap to store the groups

        for (String str : strs) {
            char[] charArray = str.toCharArray(); // Convert the string to a character array
            Arrays.sort(charArray); // Sort the character array
            String sortedStr = new String(charArray); // Create a sorted string from the character array

            // Add the original string to the corresponding list in the map
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values()); // Return the grouped anagrams as a list
    }

    public static void main(String[] args) {
        p93 ag = new p93();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = ag.groupAnagrams(strs);
        System.out.println(result); // Output the result
    }
}
