class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int numDigits = Integer.toString(x).length();
        int msdPlace = (int)Math.pow(10, numDigits-1);
        while (numDigits > 1) {
            int msd = x / msdPlace;
            if (x % 10 != msd) {
                return false;
            }
            x = (x - msd * msdPlace) / 10;
            numDigits -= 2;
            msdPlace /= 100;
        }
        return true;
    }
}
