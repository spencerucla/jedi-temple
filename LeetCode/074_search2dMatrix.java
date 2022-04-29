class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length, lo = 0, hi = matrix.length * n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target == matrix[mid / n][mid % n])
                return true;

            if (target < matrix[mid / n][mid % n]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}
