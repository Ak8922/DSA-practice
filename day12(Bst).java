//binary search tree can be applied in sorted arrays to search for a target in O(logn) time complexity
//Approach find mid and then compare the target to traverse the left or right of array
//leetcode 704(BinarySearch)
import java.util.*;
public class soln{
    public static int BinarySearch(int[] a,int target){
        int st=0;
        int end=a.length-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(a[mid]>target){
                end=mid-1;
            }
            else if(a[mid]<target){
                st=mid+1;
            }
            else{
                return mid;
            }
            }
            return -1;
        }

    
    public static void main(String[] args) {
        int[] a={-1,0,3,7,9,12};
        int target=9;
        System.out.println(BinarySearch(a, target));
    }
}

//34 irst and last occurence
import java.util.*;

public class Solution {
    public static int First(int[] a, int target) {
        int st = 0;
        int end = a.length - 1;
        int first = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (a[mid] > target) {
                end = mid - 1;
            } else if (a[mid] < target) {
                st = mid + 1;
            } else {
                first = mid;
                end = mid - 1; 
            }
        }
        return first;
    }

    public static int Last(int[] a, int target) {
        int st = 0;
        int end = a.length - 1;
        int last = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (a[mid] > target) {
                end = mid - 1;
            } else if (a[mid] < target) {
                st = mid + 1;
            } else {
                last = mid;
                st = mid + 1; 
            }
        }
        return last;
    }

    public static int[] FirstandLast(int[] a, int target) {
        int fir = First(a, target);
        if (fir == -1) {
            return new int[]{-1, -1};
        }
        int las = Last(a, target);
        return new int[]{fir, las};
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 7, 8, 8, 12};
        int target = 8;
        System.out.println(Arrays.toString(FirstandLast(a, target)));
    }
}

//35 search insert position
import java.util.*;

public class Solution {
    public static int found(int[] a, int target) {
        int st = 0;
        int end = a.length - 1;
        

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (a[mid] > target) {
                end = mid - 1;
            } else if (a[mid] < target) {
                st = mid + 1;
            } else {
                return mid;
            
            }
        }
        return st;
    }

    
    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        int target = 5;
        System.out.println((found(a, target)));
    }
}

