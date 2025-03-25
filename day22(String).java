//leetcode 921 min add to make valid string
class Solution{
    public static int minAddToMakeValid(String s) {
        int open = 0;      // Tracks unmatched '('
        int additions = 0; // Tracks total additions needed

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++; // Increment unmatched '(' count
            } else if (c == ')') {
                if (open > 0) {
                    open--; // Match with an open '('
                } else {
                    additions++; // Need an extra '(' for valid string
                }
            }
        }

        // Add any remaining unmatched '(' to additions
        additions += open;
        return additions;
    }

}
// Time Complexity: 
// 𝑂(N)
// Space Complexity: 
// 𝑂(1)


//leetcode 1781 beauty sum of all substrings
//find all substring then add to hashmap counting freq and retrieve the min and max and find diff
//sc:O(1) tc:O(n^2)
class Solution {
    public static int beautySum(String s) {
        int totalBeauty = 0; // Initialize total beauty sum
        int n = s.length();

        // Iterate through all possible substrings
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freqMap = new HashMap<>(); // Frequency map for characters

            for (int j = i; j < n; j++) {
                // Update frequency of current character
                char c = s.charAt(j);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

                // Calculate beauty of the current substring
                totalBeauty += calculateBeauty(freqMap);
            }
        }

        return totalBeauty;
    }

    // Helper method to calculate the beauty of a substring
    private static int calculateBeauty(Map<Character, Integer> freqMap) {
        int maxFreq = 0; // Maximum frequency
        int minFreq = Integer.MAX_VALUE; // Minimum frequency

        for (int freq : freqMap.values()) {
            if (freq > 0) {
                maxFreq = Math.max(maxFreq, freq);
                minFreq = Math.min(minFreq, freq);
            }
        }

        return maxFreq - minFreq; // Beauty = max frequency - min frequency
    }}
//leetcode 
