class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int idx1 = 0, idx2 = 0;
        while (idx2 < str.length) {
            if (str[idx2] == ' ') {
                reverse(str, idx1, idx2-1);
                idx1 = ++idx2;
            } else {
                ++idx2;
            }
        }
        reverse(str, idx1, idx2-1);
        return String.valueOf(str);
    }

    private void reverse(char[] s, int start, int end) {
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            char tmp = s[start+i];
            s[start+i] = s[end-i];
            s[end-i] = tmp;
        }
    }
}
