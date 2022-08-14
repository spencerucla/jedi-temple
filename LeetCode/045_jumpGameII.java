class Solution {
    public int jump(int[] nums) {
        int[] numJumps = new int[nums.length];
        Arrays.fill(numJumps, Integer.MAX_VALUE);
        numJumps[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i+j < nums.length)
                    numJumps[i+j] = Math.min(numJumps[i+j], numJumps[i]+1);
            }
        }
        return numJumps[nums.length-1];
    }
}
