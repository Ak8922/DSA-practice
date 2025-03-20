//leetcode 242 Anagram
//same letters but rearranged
//tc=o(s.length()) sc=0(k) where k is no of unique elements

import java.util.*;
public class soln{
    public static boolean anagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        HashMap <Character,Integer> freq=new HashMap<>();
        for(char c:s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);

        }
        for(char c:t.toCharArray()){
            if(!freq.containsKey(c) || freq.get(c)==0){
                return false;
            }
            freq.put(c,freq.get(c)-1);
            
        }
        return true;
    }
    public static void main(String[] args) {
        String s="tania";
        String t="manya";
        System.out.println(anagram(s, t));
        
    }
}


//leetcode 14 common prefix
//Time Complexity: O(n * log n)
//Space Complexity: O(n + m)
import java.util.*;

public class ques {
    public static String prefix(String[] s) {
        StringBuilder res=new StringBuilder();
        Arrays.sort(s);
        char[] first=s[0].toCharArray();
        char[] last=s[s.length-1].toCharArray();
         for(int i=0;i<first.length;i++){
            if(first[i]!=last[i])
           { break;}
            else{
            res.append(first[i]);}
         }
        return res.toString();
    }

    public static void main(String[] args) {
       String[] word={"flop","flag","flower"};
        System.out.println(prefix(word));
    }
}


//optimised o(n*m) o(1)
public class LongestCommonPrefix {
    public static String prefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] words = {"flop", "flag", "flower"};
        System.out.println(prefix(words));  // Output: "fl"
    }
}
