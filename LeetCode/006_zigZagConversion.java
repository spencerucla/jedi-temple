class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows-1) {
                for (int j = i; j < s.length(); j += 2*(numRows-1)) {
                    sb.append(s.charAt(j));
                }
            } else {
                for (int j = i; j < s.length(); j += 2*(numRows-1)) {
                    sb.append(s.charAt(j));
                    if (j + 2*(numRows-1-i) < s.length()) {
                        sb.append(s.charAt(j + 2*(numRows-1-i)));
                    }
                }
            }
        }
        return sb.toString();
    }
}
