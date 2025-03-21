//leetcode 1614 find max parentheses
//tc=O(n) sc=O(1)
import java.util.*;
public class soln{
    public static int depth(String s){
        int max=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                count++;
                max=Math.max(count,max);
            }
            if(c==')'){
                count--;
                max=Math.max(count,max);
            }
           
        }
        return max;
    }
    public static void main(String[] args) {
        String s="((8+3)+5)";
        System.out.println(depth(s));

    }
}

//leetcode 13 roman num to integer
//tc=O(n) sc=O(1)
 public int romanToInt(String s) {
         int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
