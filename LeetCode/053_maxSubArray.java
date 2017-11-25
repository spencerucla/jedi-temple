class Solution {
    public int maxSubArray(int[] nums) {
        int runningMax = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningMax += nums[i];
            if (runningMax < nums[i])
                runningMax = nums[i];
            if (runningMax > maxSoFar)
                maxSoFar = runningMax;
        }
        return maxSoFar;
    }
}
