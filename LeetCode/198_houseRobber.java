class Solution {
    public int rob(int[] nums) {
        int prevMax = 0, prevPrevMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = Math.max(nums[i] + prevPrevMax, prevMax);
            prevPrevMax = prevMax;
            prevMax = max;
        }
        return prevMax;
    }
}
