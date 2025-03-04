leetcode 832:
import java.util.*;

public class Ques {

    public static int[][] invertAndFlip(int[][] a) {
        int n = a[0].length;
        
        for (int[] row : a) {
            
            for (int i = 0; i < n / 2; i++) {
                int temp = row[i];
                row[i] = row[n - 1 - i];
                row[n - 1 - i] = temp;
            }
           
            for (int i = 0; i < n; i++) {
                row[i] = row[i] == 0 ? 1 : 0;
            }
        }
        return a;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); 
        }
    }
    
    public static void main(String[] args) {
        int[][] a = {{1, 0}, {0, 1}, {1, 1}};
        int[][] invertedAndFlippedMatrix = invertAndFlip(a);
        printMatrix(invertedAndFlippedMatrix);
    }
}


leetcode 1182:
import java.util.*;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        List<int[]> list = new LinkedList<>();
        int result = 0;

        for (int[] domino : dominoes) {
            boolean found = false;
            for (int[] d : list) {
                if ((d[0] == domino[0] && d[1] == domino[1]) || (d[0] == domino[1] && d[1] == domino[0])) {
                    found = true;
                    break;
                }
            }
            if (found) {
                result++;
            } else {
                list.add(domino);
            }
        }
        
        return result;
    }
}

