//leetcode 838 push dominoes
  import java.util.*;

public class Solution {
    public static String dominoes(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] forces = new int[n];

        // Calculate forces from the right-pushing 'R'
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') {
                force = n; // Strong force from 'R'
            } else if (arr[i] == 'L') {
                force = 0; // Reset force due to 'L'
            } else {
                force = Math.max(force - 1, 0); // Gradual decay of force
            }
            forces[i] += force;
        }

        // Calculate forces from the left-pushing 'L'
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') {
                force = n; // Strong force from 'L'
            } else if (arr[i] == 'R') {
                force = 0; // Reset force due to 'R'
            } else {
                force = Math.max(force - 1, 0); // Gradual decay of force
            }
            forces[i] -= force; // Subtract leftward forces
        }

        // Determine the final state of dominoes based on net forces
        StringBuilder result = new StringBuilder();
        for (int f : forces) {
            if (f > 0) {
                result.append('R');
            } else if (f < 0) {
                result.append('L');
            } else {
                result.append('.');
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String s = ".L.R...LR..L..";
        System.out.println(dominoes(s)); // Output: LL.RR.LLRRLL..
    }
}


  //leetcode763 partition label
  //hashmap the last occurence
  import java.util.*;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        // Step 1: Calculate the last occurrence of each character
        int[] last = new int[26]; // Store the last index for each character (a to z)
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i; // Record the last occurrence of each character
        }

        // Step 2: Partition the string based on the last occurrence
        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']); // Expand the current partition
            if (i == end) { // If we've reached the end of the partition
                partitions.add(end - start + 1); // Record the size of the partition
                start = i + 1; // Start a new partition
            }
        }

        return partitions;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(s);
        System.out.println(result); // Output: [9, 7, 8]
    }
}
  

  
