class Solution {
    public int majorityElement(int[] nums) {
        int x = 0;
        int i = 0;
        for (int num : nums) {
            if (i == 0) {
                x = num;
                i = 1;
            } else if (num == x) {
                i++;
            } else {
                i--;
            }
        }
        return x;
    }
}
