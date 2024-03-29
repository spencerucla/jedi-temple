class Solution {
    public void sortColors(int[] nums) {
        int zeroes = 0, ones = 0, twos = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroes++;
            } else if (num == 1) {
                ones++;
            } else {
                twos++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroes-- > 0) {
                nums[i] = 0;
            } else if (ones-- > 0) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
