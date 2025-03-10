//gfg:max score of min subarray
import java.util.*;
public class ques{
    public static int MaxScore(int[] a){
        int ans=Integer.MIN_VALUE;
        int n=a.length;
        
        for(int i=0;i<n-1;i++){
            if(a[i]+a[i+1]>ans){
                ans=a[i]+a[i+1];
                
            }
            }
            return ans;
        }
        public static void main(String[] args) {
            int[] a={4,3,1,5,6};
            System.out.println(MaxScore(a));
        }

    }

tc:O(n)
sc:O(1)
