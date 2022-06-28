class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), ret, new boolean[nums.length]);
        return ret;
    }

    private void dfs(int[] nums, List<Integer> curr, List<List<Integer>> ret, boolean[] used) {
        if (curr.size() == nums.length) {
            ret.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i-1] == nums[i] && used[i-1]) continue;
            curr.add(nums[i]);
            used[i] = true;
            dfs(nums, curr, ret, used);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}
