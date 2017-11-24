class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public int removeDuplicatesBAD(int[] nums) {
        int i = 0;
        int count = 1;
        for (int j = 1; i < nums.length && j < nums.length; i++) {
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            if (j < nums.length) {
                nums[i+1] = nums[j];
                count++;
            }
        }
        return count;
    }
}
