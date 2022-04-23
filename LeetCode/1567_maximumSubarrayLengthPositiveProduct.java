class Solution {
    public int getMaxLen(int[] nums) {
        int max = 0, curPosLen = 0, curNegLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                curPosLen = 0;
                curNegLen = 0;
            } else if (nums[i] > 0) {
                curPosLen++;
                curNegLen = curNegLen == 0 ? 0 : curNegLen + 1;
            } else {
                int tmp = curPosLen;
                curPosLen = curNegLen == 0 ? 0 : curNegLen + 1;
                curNegLen = tmp + 1;
            }
            max = Math.max(max, curPosLen);
        }
        return max;
    }
}
