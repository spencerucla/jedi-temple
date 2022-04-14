class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;

        int[] counts = new int[26];
        for (int i = 0; i < len1; i++) {
            counts[s2.charAt(i)-'a']++;
            counts[s1.charAt(i)-'a']--;
        }
        if (allZero(counts)) return true;

        for (int i = len1; i < len2; i++) {
            counts[s2.charAt(i)-'a']++;
            counts[s2.charAt(i - len1)-'a']--;
            if (allZero(counts)) return true;
        }
        return false;
    }

    private boolean allZero(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
