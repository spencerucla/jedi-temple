class Solution {
    public int reverse(int x) {
        long tmp = 0;
        int sign = (x > 0) ? 1 : -1;
        x = Math.abs(x);
        while (x > 0) {
            tmp = tmp * 10 + (x % 10);
            x /= 10;
        }
        if (tmp > Integer.MAX_VALUE)
            return 0;
        return sign * (int)tmp;
    }
}
