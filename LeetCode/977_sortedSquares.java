class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] copy = new int[nums.length];
        int i = 0, j = nums.length-1;
        for (int k = nums.length-1; k >= 0; k--) {
            if (Math.abs(nums[i]) - Math.abs(nums[j]) > 0) {
                // take from beginning
                copy[k] = nums[i] * nums[i];
                i++;
            } else {
                // take from end
                copy[k] = nums[j] * nums[j];
                j--;
            }
        }
        return copy;
    }
}
