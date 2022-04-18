class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> d = new HashSet<>(wordDict);
        Map<String, Boolean> cache = new HashMap<>();
        return searchWords(s, d, cache);
    }

    private boolean searchWords(String s, Set<String> wordDict, Map<String, Boolean> cache) {
        if (cache.containsKey(s)) return cache.get(s);
        if (wordDict.contains(s)) return true;

        for (int i = 1; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i)) && searchWords(s.substring(i), wordDict, cache)) {
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] found = new boolean[s.length()+1];
        found[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (found[j] && wordDict.contains(s.substring(j, i))) {
                    found[i] = true;
                    break;
                }
            }
        }
        return found[s.length()];
    }
}
