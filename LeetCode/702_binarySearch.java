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
}
