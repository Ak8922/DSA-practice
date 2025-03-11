//leetcode 2149
import java.util.*;

public class ques {
    public static int[] Rearrange(int[] a) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

    
        for (int num : a) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        int[] result = new int[a.length];
        int posIndex = 0, negIndex = 0, index = 0;

        // Alternate between positive and negative numbers
        while (posIndex < positive.size() && negIndex < negative.size()) {
            result[index++] = positive.get(posIndex++);
            result[index++] = negative.get(negIndex++);
        }
  //in case of unequal arrays
        // Append remaining positive or negative numbers
        while (posIndex < positive.size()) {
            result[index++] = positive.get(posIndex++);
        }
        while (negIndex < negative.size()) {
            result[index++] = negative.get(negIndex++);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(Rearrange(a)));
    }
}

//tc=O(n) sc=O(n)


//leetcode 121 
public class StockProfit {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int minPrice = Integer.MAX_VALUE; // Initialize with a large value
        int maxProfit = 0; // Initialize the max profit as zero

        for (int price : prices) {
            // Update the minimum price seen so far
            if (price < minPrice) {
                minPrice = price;
            }

            // Calculate profit for selling at current price
            int profit = price - minPrice;

            // Update the maximum profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices));
    }
}
//tc=O(n)
//sc=O(1)

//leetcode 31

import java.util.Arrays;

class soln{
    static void nextPermutation(int[] arr) {
        int n = arr.length;

        // Find the pivot index
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If pivot point does not exist, reverse the whole array
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return ;
        }

        // Find the element from the right that is greater than pivot
        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                swap(arr, i, pivot);
                break;
            }
        }

        // Reverse the elements from pivot + 1 to the end
        reverse(arr, pivot + 1, n - 1);
    }

    // Helper method to reverse array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    // Helper method to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 7, 5, 0 };
        nextPermutation(arr);
        
        for(int i = 0; i < arr.length; i++)
        System.out.print(arr[i] + " ");
    }
}

//tc=O(n)
//  sc-O(1)




