class Solution {
    public int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i+1 < s.length(); i++) {
            int curr = dig(s.charAt(i));
            if (curr < dig(s.charAt(i+1))) {
                // subtractive notation
                num -= curr;
            } else {
                num += curr;
            }
        }
        num += dig(s.charAt(s.length()-1));
        return num;
    }

    private int dig(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default:   throw new IllegalArgumentException("Not a valid roman numeral");
        }
    }
}
