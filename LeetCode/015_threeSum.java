class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; // don't start twoSum with same # twice
            for (int j = i+1, k = nums.length-1; j < k; /* see body */) {
                int sum = 0 - nums[i];
                if (nums[j] + nums[k] == sum) {
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j+1]) j++;
                    while (j < k && nums[k-1] == nums[k]) k--;
                    j++; k--;
                } else if (nums[j] + nums[k] < sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ret;
    }
}
