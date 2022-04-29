class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] { -1, -1 };

        // find left-most
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target <= nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        if (nums[low] != target)
            return new int[] { -1, -1 };
        int left = low;

        // find right-most
        high = nums.length - 1;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (target >= nums[mid]) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return new int[] { left, low };
    }
}
