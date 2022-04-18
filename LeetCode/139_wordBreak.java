class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> d = new HashSet<>(wordDict);
        return searchWords(s, d);
    }

    private boolean searchWords(String s, Set<String> wordDict) {
        if (wordDict.contains(s)) return true;

        for (int i = 1; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i)) && searchWords(s.substring(i), wordDict)) {
                return true;
            }
        }
        return false;
    }
}
