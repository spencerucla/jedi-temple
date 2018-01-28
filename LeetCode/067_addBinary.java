class Solution {
    public String addBinary(String a, String b) {
        String str = "";
        int carry = 0;
        for (int i = a.length()-1, j = b.length()-1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            if (i >= 0)
                carry += a.charAt(i) - '0';
            if (j >= 0)
                carry += b.charAt(j) - '0';
            str = (carry % 2) + str;
            carry /= 2;
        }
        return str;
    }
}
