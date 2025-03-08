leetcode 605
import java.util.*;
public class Ques{
    public static boolean placeFlower(int [] a,int n){
    int count=0;
    for (int i = 0; i < a.length; i++) {
      
        if (a[i] == 0 
            && (i == 0 || a[i - 1] == 0) 
            && (i == a.length - 1 || a[i + 1] == 0)) {
            
            a[i] = 1;
            count++;
            }
        }
     
     if(count==n){
        return true;
     }
     else 
     return false;
     }

    
public static void main(String[] args) {
    
int[] a={1,0,0,0,1};
int n=1;
System.out.println(placeFlower(a, n));
  

}}


leetcode 3364

  public class MinPositiveSumSubarray {
    public static int minPositiveSumSubarray(int[] nums, int l, int r) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int windowSum = 0;
            for (int j = i; j < Math.min(n, i + r); j++) {
                windowSum += nums[j];
                int windowSize = j - i + 1;

                if (windowSize >= l && windowSize <= r && windowSum > 0) {
                    minSum = Math.min(minSum, windowSum);
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public static void main(String[] args) {
        int[] nums = {3, -2, 1, 4};
        int l = 2;
        int r = 3;

        int result = minPositiveSumSubarray(nums, l, r);
        System.out.println(result); 
    }
}

  




