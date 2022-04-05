class Solution {
    public void moveZeroes(int[] nums) {
        int nextZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nextZero++] = nums[i];
            }
        }
        for (; nextZero < nums.length; nextZero++) {
            nums[nextZero] = 0;
        }
    }
}
