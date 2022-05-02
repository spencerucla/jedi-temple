class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length())
            return list;

        int[] counts = new int[26];
        for (int i = 0; i < p.length(); i++) {
            counts[s.charAt(i)-'a']++;
            counts[p.charAt(i)-'a']--;
        }

        for (int i = p.length(); i < s.length(); i++) {
            if (allZeros(counts))
                list.add(i - p.length());
            counts[s.charAt(i)-'a']++;
            counts[s.charAt(i - p.length())-'a']--;
        }
        if (allZeros(counts))
            list.add(s.length() - p.length());
        return list;
    }

    private boolean allZeros(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
