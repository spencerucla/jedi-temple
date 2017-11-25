class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                lo = mid+1;
            } else { // target < nums[mid]
                hi = mid-1;
            }
        }
        return (target > nums[lo]) ? lo+1 : lo;
    }
}
