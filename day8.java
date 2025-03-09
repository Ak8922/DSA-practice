leetcode 283:
import java.util.*;
public class ques{
    public static void moveZero(int[] a){
        int count=0;
        Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<a.length;i++){
        
        if(a[i]==0){
            count++;
            continue;

        }
        else
        q.add(a[i]);
    }
       for(int j=0;j<count;j++){
        q.add(0);
       }
       System.out.println(q);
    }
public static void main(String[] args){
    int[] a={0,1,0,3,0,12,0};
    moveZero(a);

}}

//tc=0(n)
//sc:0(n)


leetcode 189:
import java.util.*;
public class ques{
    public static void rotateArray(int[] a,int k){
        if(k<0){
            System.out.println("invalid");
        }
        int n=a.length;
        int[] b= new int[n];
        for(int i=0;i<n;i++){
        b[(i+k)%n]=a[i];}
        for(int el:b){
            System.out.println(el);
    }}
public static void main(String[] args){
        int[] a={1,2,3,4,5};
        int k=7;
        rotateArray(a,k);
       
        
    }
}
//tc=0(n)
//sc=0(n)



OR

//optimised soln
  public class RotateArray {
    public static void rotateArray(int[] a, int k) {
        int n = a.length;
        k = k % n; // Handle cases where k > n

        if (k < 0) { // Handle negative rotations if needed
            System.out.println("Invalid input");
            return;
        }

        // Step 1: Reverse the entire array
        reverse(a, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(a, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(a, k, n - 1);

        // Print the rotated array
        for (int el : a) {
            System.out.print(el + " ");
        }
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int k = 7;
        rotateArray(a, k);
    }
}
