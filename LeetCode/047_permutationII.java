class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        dfs(nums, new ArrayList<>(), set, new boolean[nums.length]);
        List<List<Integer>> ret = new ArrayList<>();
        ret.addAll(set);
        return ret;
    }

    private void dfs(int[] nums, List<Integer> curr, Set<List<Integer>> ret, boolean[] used) {
        if (curr.size() == nums.length) {
            ret.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            curr.add(nums[i]);
            used[i] = true;
            dfs(nums, curr, ret, used);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}
