leetcode 1:
import java.util.*;
public class ques{
    public static void Sum(int[] a,int target){
        Arrays.sort(a);
        int left=a[0];
        int right=a[a.length-1];
        // int sum=;
        while((left+right)!=target){
           
        
        if(left+right<target){
            left++;}

        else{
            right--;
        }
    }
    System.out.println(left+","+right);

    }
    public static void main(String[] args) {
        int[] a={3,8,4,5,6};
        int target=9;
        Sum(a, target);
    }}
tc:o(nlogn)
sc:o(1)



leetcode 75:

import java.util.*;

public class ques {
    public static int[] SortColor(int[] a) {
        int count0 = 0, count1 = 0, count2 = 0;

        // Count the occurrences of 0, 1, and 2
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                count0++;
            } else if (a[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        // Overwrite the array with sorted values
        for (int j = 0; j < count0; j++) {
            a[j] = 0;
        }
        for (int j = count0; j < count0 + count1; j++) {
            a[j] = 1;
        }
        for (int j = count0 + count1; j < count0 + count1 + count2; j++) {
            a[j] = 2;
        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 0, 2, 0, 1, 0, 2, 1, 0, 2, 2};
        System.out.println(Arrays.toString(SortColor(a)));
    }
}

tc:o(n)
sc:o(1)


