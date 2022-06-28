class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        /*
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        dfs(ret, new ArrayList<Integer>(), numsList);
        */
        dfs(nums, new ArrayList<>(), ret, new boolean[nums.length]);
        return ret;
    }

    // could also use int[] and check if tmp.contains(nums[i])
    private void dfs(List<List<Integer>> ret, List<Integer> tmp, List<Integer> remaining) {
        if (remaining.size() == 0) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < remaining.size(); i++) {
            tmp.add(remaining.remove(i));
            dfs(ret, tmp, remaining);
            remaining.add(i, tmp.remove(tmp.size()-1));
        }
    }

    private void dfs(int[] nums, List<Integer> curr, List<List<Integer>> list, boolean[] used) {
        if (curr.size() == nums.length) {
            list.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            curr.add(nums[i]);
            used[i] = true;
            dfs(nums, curr, list, used);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}
