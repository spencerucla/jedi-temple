class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (target == nums[mid])
            return mid;
        if (left >= right)
            return -1;

        if (target > nums[mid]) // right half
            return search(nums, target, mid+1, right);
        else                    // left half
            return search(nums, target, left, mid-1);
    }

    public int searchIter(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (target < nums[mid]) {
                hi = mid-1;
            } else {
                lo = mid;
            }
        }
        return target == nums[lo] ? lo : -1;
    }
}
