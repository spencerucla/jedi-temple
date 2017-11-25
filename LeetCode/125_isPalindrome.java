class Solution {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            while (i < s.length() && !isAlphaNumeric(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !isAlphaNumeric(s.charAt(j))) {
                j--;
            }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}
