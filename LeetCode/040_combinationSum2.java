class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        sortDescending(candidates);
        dfs(ret, new ArrayList<Integer>(), candidates, 0, target);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> tmp, int[] nums, int start, int remaining) {
        if (remaining == 0) {
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remaining)                continue;   // skip if too big
            if (i > start && nums[i] == nums[i-1])  continue;   // skip dupes
            tmp.add(nums[i]);
            dfs(ret, tmp, nums, i+1, remaining - nums[i]);
            tmp.remove(tmp.size()-1);
        }
    }

    // another option: negate, sort, negate back
    private void sortDescending(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
    }
}
