class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>(), list);
        return list;
    }

    private void dfs(int n, int k, int start, List<Integer> curr, List<List<Integer>> list) {
        if (k == 0) {
            list.add(new ArrayList<>(curr));
            return;
        }
        // invariant: only add bigger #s than last of curr
        for (int i = start; i <= n; i++) {
            curr.add(i);
            dfs(n, k-1, i+1, curr, list);
            curr.remove(curr.size()-1);
        }
    }
}
