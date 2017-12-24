class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        dfs(ret, "", n, n);
        return ret;
    }

    private void dfs(List<String> ret, String curr, int opensLeft, int closesLeft) {
        if (opensLeft == 0 && closesLeft == 0)
            ret.add(curr);
        if (opensLeft > 0)
            dfs(ret, curr + "(", opensLeft-1, closesLeft);
        if (closesLeft > 0 && closesLeft > opensLeft)
            dfs(ret, curr + ")", opensLeft, closesLeft-1);
    }
}
