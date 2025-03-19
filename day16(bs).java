//leetcode 1901
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int left = 0, right = cols - 1;

        while (left <= right) {
            int midCol = left + (right - left) / 2;

            // Find the maximum element in the middle column
            int maxRow = 0;
            for (int i = 0; i < rows; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            // Check if the maximum element is a peak
            boolean isLeftSmaller = (midCol == 0 || mat[maxRow][midCol] > mat[maxRow][midCol - 1]);
            boolean isRightSmaller = (midCol == cols - 1 || mat[maxRow][midCol] > mat[maxRow][midCol + 1]);

            if (isLeftSmaller && isRightSmaller) {
                // Found a peak
                return new int[]{maxRow, midCol};
            } else if (!isLeftSmaller) {
                // Move to the left half
                right = midCol - 1;
            } else {
                // Move to the right half
                left = midCol + 1;
            }
        }

        return new int[]{-1, -1}; // This line should not be reached
    }
}


//gfg median in row wise sorted array
class Solution {
    public int findMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 1; // Minimum possible value in the matrix
        int high = 100000; // Maximum possible value in the matrix

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            // Count elements less than or equal to mid
            for (int i = 0; i < rows; i++) {
                count += countSmallerThanOrEqualToMid(matrix[i], mid);
            }

            if (count < (rows * cols + 1) / 2) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countSmallerThanOrEqualToMid(int[] row, int mid) {
        int low = 0, high = row.length - 1;

        while (low <= high) {
            int m = low + (high - low) / 2;
            if (row[m] <= mid) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }

        return low;
    }
}

