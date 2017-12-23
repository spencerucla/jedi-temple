class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        sortDescending(nums);
        dfs(ret, new ArrayList<Integer>(), nums, 0);
        return ret;
    }

    // with backtracking
    private void dfs(List<List<Integer>> ret, List<Integer> tmp, int[] nums, int start) {
        ret.add(new ArrayList<Integer>(tmp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue; // skip dupes
            tmp.add(nums[i]);
            dfs(ret, tmp, nums, i+1);
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
