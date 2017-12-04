class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int curlen = 0, maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                curlen++;
            } else {
                maxlen = Math.max(curlen, maxlen);
                int removePos = map.get(c);
                for (char c2 : s.substring(i-curlen, removePos+1).toCharArray())
                    map.remove(c2);
                map.put(c, i);
                curlen -= (removePos - i + curlen);
            }
        }
        return Math.max(curlen, maxlen);
    }
}
