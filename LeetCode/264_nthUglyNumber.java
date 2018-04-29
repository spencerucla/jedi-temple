class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(next2, next3), next5);
            ugly[i] = min;
            if (min == next2)
                next2 = 2 * ugly[++index2];
            if (min == next3)
                next3 = 3 * ugly[++index3];
            if (min == next5)
                next5 = 5 * ugly[++index5];
        }
        return ugly[n-1];
    }
}
