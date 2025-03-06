leetcode 2591
  public class DistributeMoney {
    public static int distributeMoney(int money, int children) {
        
        if (money < children) return -1
        money -= children;
       int maxEight = Math.min(money / 7, children); 
        money -= maxEight * 7;
        children -= maxEight;
      if (children == 1 && money == 4) {
            if (maxEight > 0) {
                maxEight--;
            } else {
                return -1;
            }
        }

        return maxEight;
    }

  leetcode 409
  public class LongestPalindrome {
    public static int longestPalindrome(String s) {
    
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int palindromeLength = 0;
        boolean hasOdd = false;

       
        for (int freq : count) {
            
            palindromeLength += (freq / 2) * 2;
          
            if (freq % 2 != 0) {
                hasOdd = true;
            }
        }

       
        if (hasOdd) {
            palindromeLength += 1;
        }

        return palindromeLength;
    }

  
}


   
