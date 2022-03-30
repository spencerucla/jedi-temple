class Solution {
    public void rotate(int[] nums, int k) {
        // idea #1 - rotate by 1, k times - space O(1), time O(n*k)
        // idea #2 - save k off end, rotate rest by k, replace 1st k w/saved - space O(k), time O(n)
		//   preferred, minimal memory usage for k-factor time savings
        k = k % nums.length;
        int[] saved = new int[k];
        for (int i = 0; i < k; i++) {
            saved[i] = nums[nums.length-k+i];
        }
        for (int i = nums.length-1-k; i >= 0; i--) {
            nums[k+i] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = saved[i];
        }
    }
}
