class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        if (nums.length > 0) {
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        // TODO: check range of j
        return (i > 0) ? sums[j] - sums[i-1] : sums[j];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
