//leetcode 686
import java.util.*;

public class ArrayLC {
    public static int repeated(String s, String t) {
        StringBuilder temp = new StringBuilder(s);
        int count = 1;

        // Keep appending `s` to `temp` until its length is greater than or equal to `t`
        while (temp.length() < t.length()) {
            temp.append(s);
            count++;
        }

        // Check if `t` is now a substring of `temp`
        if (temp.toString().contains(t)) {
            return count;
        }

        // Append `s` one more time and check again
        temp.append(s);
        if (temp.toString().contains(t)) {
            return count + 1;
        }

        // If `t` is not found even after the additional append
        return -1;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "cabca";

        // Print the result
        System.out.println(repeated(s, t)); // Output: 2
    }
}


//leetcode 214 shortest palindrome
import java.util.*;

public class Solution {
    public static String shortPalin(String s) {
        // If the string is already a palindrome, return it directly
        if (isPalindrome(s)) {
            return s;
        }

        // Reverse the string
        StringBuilder reversed = new StringBuilder(s).reverse();

        // Iterate to find the point where the palindrome starts
        for (int i = 0; i < s.length(); i++) {
            // Check if the substring of `s` from the current position forms a palindrome
            if (s.substring(0, s.length() - i).equals(reversed.substring(i))) {
                return reversed.substring(0, i) + s;
            }
        }

        // Default case (not strictly required but a fallback)
        return reversed.append(s).toString();
    }

    // Helper method to check if a string is a palindrome
    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(shortPalin(s)); // Output: "cbabc"

        String s2 = "aacecaaa";
        System.out.println(shortPalin(s2)); // Output: "aacecaaa" (already a palindrome)

        String s3 = "abcd";
        System.out.println(shortPalin(s3)); // Output: "dcbabcd"
    }
}


