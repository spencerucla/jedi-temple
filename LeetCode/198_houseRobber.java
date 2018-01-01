class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] mem = new int[nums.length];
        mem[0] = nums[0];
        mem[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            mem[i] = Math.max(mem[i-2] + nums[i], mem[i-1]);
        }
        return mem[nums.length-1];
    }
}
