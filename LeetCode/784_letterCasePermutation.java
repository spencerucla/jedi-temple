class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> permutations = new ArrayList<>();
        dfs("", s.toLowerCase(), permutations);
        return permutations;
    }

    private void dfs(String curr, String rem, List<String> rets) {
        if (rem.length() == 0) {
            rets.add(curr);
            return;
        }

        char c = rem.charAt(0);
        if (c >= 'a' && c <= 'z') {
            dfs(curr + c, rem.substring(1), rets);
            dfs(curr + Character.toUpperCase(c), rem.substring(1), rets);
        } else {
            dfs(curr + c, rem.substring(1), rets);
        }
    }
}
