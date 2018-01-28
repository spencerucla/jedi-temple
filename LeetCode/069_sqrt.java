class Solution {
    public int mySqrt(int x) {
        long lo = 1, hi = x;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (mid * mid == x)
                return (int)mid;
            if (mid * mid < x && (mid + 1) * (mid + 1) > x)
                return (int)mid;
            if (mid * mid > x)
                hi = mid;
            else
                lo = mid;
        }
        return 0;
    }

    public int mySqrtNewton(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int)r;
    }
}
