class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(ret, new ArrayList<Integer>(), nums, 0);
        return ret;
    }

    // with backtracking
    private void dfs(List<List<Integer>> ret, List<Integer> tmp, int[] nums, int start) {
        ret.add(new ArrayList<Integer>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(ret, tmp, nums, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
