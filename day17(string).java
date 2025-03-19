//leetcode 1021
public String removeOuterParentheses(String s) {
    StringBuilder result = new StringBuilder();
    int balance = 0;

    for (char c : s.toCharArray()) {
        if (c == '(') {
            if (balance > 0) {
                result.append(c);
            }
            balance++;
        } else {
            balance--;
            if (balance > 0) {
                result.append(c);
            }
        }
    }

    return result.toString();
}


//leetcode 205
import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Strings of different lengths cannot be isomorphic
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check mapping from s -> t
            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false; // Conflict in mapping
                }
            } else {
                mapST.put(charS, charT);
            }

            // Check mapping from t -> s
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false; // Conflict in mapping
                }
            } else {
                mapTS.put(charT, charS);
            }
        }

        return true; // All mappings are consistent
    }
}
