//leetcode 451
//hashmap,stringbuilder,count freq
    public static String SortbyFreq(String s) {
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Build the answer string by repeatedly finding the max frequency
        while (s.length() > ans.length()) {
            int maxFreq = 0;
            char maxchar = '\0';

            // Find the character with the maximum frequency
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    maxchar = entry.getKey();
                }
            }

            // Append the character with max frequency to the result
            for (int i = 0; i < maxFreq; i++) {
                ans.append(maxchar);
            }

            // Remove the character from the map
            map.remove(maxchar);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String input = "abbccaaac";
        System.out.println("Sorted by frequency: " + SortbyFreq(input));
    }
}


optimised
  

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        
        pq.addAll(hm.entrySet());
        
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        
        return result.toString();
    }
}

//leetcode 8 atoi
public class Solution {
    public int myAtoi(String s) {
        // Step 1: Handle empty string
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Step 2: Trim leading and trailing whitespaces
        s = s.trim();

        // Step 3: Check if the string is empty after trimming
        if (s.length() == 0) {
            return 0;
        }

        // Step 4: Determine the sign
        int sign = 1;
        int index = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        // Step 5: Convert characters to integer
        long result = 0; // Use long to handle overflow during calculation
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');
            index++;

            // Step 6: Handle overflow
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) (result * sign);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42")); // Output: 42
        System.out.println(solution.myAtoi("   -42")); // Output: -42
        System.out.println(solution.myAtoi("4193 with words")); // Output: 4193
        System.out.println(solution.myAtoi("words and 987")); // Output: 0
        System.out.println(solution.myAtoi("-91283472332")); // Output: -2147483648 (clamped to Integer.MIN_VALUE)
    }
}
