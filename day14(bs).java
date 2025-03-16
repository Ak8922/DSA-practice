//gfg sq root
import java.util.*;

public class Solution {
    public static int sqroot(int n) {
        int st = 0;
        int end = n;
        int result = -1; // To store the floor value of the square root

        while (st <= end) {
            int mid = st + (end - st) / 2; // Calculate mid to prevent overflow

            if (mid * mid == n) {
                return mid; // Found the perfect square root
            } else if (mid * mid < n) {
                result = mid; // Store the closest value so far
                st = mid + 1; // Search in the right half
            } else {
                end = mid - 1; // Search in the left half
            }
        }

        return result; // If not a perfect square, return floor value
    }

    public static void main(String[] args) {
        int n = 625;
        System.out.println("Square root of " + n + " is: " + sqroot(n));
    }
}


//koko bananas
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum possible speed
        int right = getMax(piles); // Maximum possible speed (the largest pile)
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                result = mid; // Try a smaller speed
                right = mid - 1;
            } else {
                left = mid + 1; // Increase the speed
            }
        }

        return result;
    }

    // Helper function to check if Koko can finish in 'h' hours at speed 'k'
    private boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / k); // Calculate time for each pile
        }
        return hours <= h;
    }

    // Helper function to find the maximum pile size
    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    public static void main(String[] args) {
        KokoEatingBananas koko = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println("Minimum eating speed: " + koko.minEatingSpeed(piles, h));
    }
}

//1283 leetcode 
//smallest divisor
public class SmallestDivisor {
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1; // The smallest possible divisor
        int high = getMax(nums); // The largest element in the array
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Middle value of the current range
            if (sumAfterDivision(nums, mid) <= threshold) {
                result = mid; // Update result as we want the smallest divisor
                high = mid - 1; // Try for smaller divisor
            } else {
                low = mid + 1; // Try for a larger divisor
            }
        }

        return result;
    }

    // Helper function to calculate the sum after division with a divisor
    private static int sumAfterDivision(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // Equivalent to Math.ceil(num / (double) divisor)
        }
        return sum;
    }

    // Helper function to find the maximum value in the array
    private static int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println("Smallest Divisor: " + smallestDivisor(nums, threshold));
    }
}
