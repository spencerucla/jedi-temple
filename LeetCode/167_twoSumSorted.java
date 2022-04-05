class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int ret = search(numbers, target - numbers[i], i+1, len-1);
            if (ret != -1) {
                return new int[] { i+1, ret+1 };
            }
        }
        return new int[] { -1, -1 };
    }

    private int search(int[] numbers, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (target == numbers[mid]) {
            return mid;
        }
        if (start >= end) {
            return -1;
        }
        if (target > numbers[mid]) {
            return search(numbers, target, mid+1, end); // right half
        } else {
            return search(numbers, target, start, mid); // left half
        }
    }
}
