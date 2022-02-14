class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length && prefix.length() > 0; i++) {
            boolean match = false;
            while (prefix.length() > 0 && !match) {
                match = prefix.equals(strs[i].substring(0, Math.min(prefix.length(), strs[i].length())));
                if (!match) {
                    prefix = prefix.substring(0, prefix.length()-1);
                }
            }
        }
        return prefix;
    }
}
