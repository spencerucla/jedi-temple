class Solution {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length-1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (target == nums[mid])
                return mid;
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target <= nums[mid]) {
                    // left half is sorted and target is in left half
                    hi = mid - 1;
                } else {
                    // left half is sorted, but target is in right half
                    lo = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[hi]) {
                    // right half is sorted and target is in right half
                    lo = mid + 1;
                } else {
                    // right half is sorted, but target is in left half
                    hi = mid - 1;
                }
            }
        }
        return nums[lo] == target ? lo : -1;
    }
}
