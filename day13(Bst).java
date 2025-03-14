//time complexity=O(logn)
//leetcode 33 Rotated sorted array
import java.util.*;
public class ques{
    public static int RotatedArr(int[] a,int target){
       int st=0;
       int end=a.length-1;
       while(st<=end){
        int mid=st+(end-st)/2;
        if(a[mid]==target){
           return mid;
        }
        if(a[mid]<a[end])//right sorted
        {if(a[mid]<=target && a[end]>=target){
            st=mid+1;
        }
        else{
            end=mid-1;
        }
        }
        else{
            if(a[st]<a[mid]){
                if(a[mid]>=target && a[st]<=target){
                    end=mid-1;
                }
                else{
                    st=mid+1;
                }
            }
        }
       }
       return -1;  }
    
        public static void main(String[] args) {
            int[] a={3,4,5,6,7,8,9,1,2};
            int target=3;
            System.err.println(RotatedArr(a, target));    }

//leetcode 153 min in rotated sorted array
public class ques{
    public static int minValue(int[] a){
        int k=Integer.MAX_VALUE;
       int st=0;
       int end=a.length-1;
       while(st<=end){
        int mid=st+(end-st)/2;
        
        if(a[mid]<k){
            k=a[mid];
        }

        if(a[mid]<a[end])//right sorted
        {end=mid-1;
        }
       else{
        st=mid+1;
       }
      
        } return k;
    }
    
        public static void main(String[] args) {
            int[] a={3,4,5,6,7,8,9,1,2};
            
            System.err.println(minValue(a));
            




  //ceiling
  public int findCeiling(int[] arr, int target) {
    int start = 0, end = arr.length - 1;
    int ceiling = -1; // Default if no ceiling exists

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (arr[mid] >= target) {
            ceiling = arr[mid]; // Possible ceiling
            end = mid - 1;      // Search left for a smaller ceiling
        } else {
            start = mid + 1;    // Search right
        }
    }
    return ceiling; // Returns -1 if no ceiling is found
}


  //floor
  public int findFloor(int[] arr, int target) {
    int start = 0, end = arr.length - 1;
    int floor = -1; // Default if no floor exists

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (arr[mid] <= target) {
            floor = arr[mid];  // Possible floor
            start = mid + 1;   // Search right for a larger floor
        } else {
            end = mid - 1;     // Search left
        }
    }
    return floor; // Returns -1 if no floor is found
}
