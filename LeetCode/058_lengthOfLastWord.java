class Solution {
    public int lengthOfLastWord(String s) {
        int wordEnd = -1;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && wordEnd == -1) {
                wordEnd = i;
            } else if (s.charAt(i) == ' ' && wordEnd >= 0) {
                return wordEnd - i;
            }
        }
        return (wordEnd >= 0) ? wordEnd+1 : 0;
    }
}
