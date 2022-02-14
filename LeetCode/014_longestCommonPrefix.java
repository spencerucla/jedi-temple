class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for (int j = 0; j < strs[0].length(); j++) {
            prefix += strs[0].charAt(j);
            boolean allMatch = true;
            for (int i = 0; i < strs.length /* && allMatch */; i++) {
                if (j >= strs[i].length() || strs[i].charAt(j) != prefix.charAt(j)) {
                    allMatch = false;
                }
            }
            if (!allMatch) {
                return prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
}
