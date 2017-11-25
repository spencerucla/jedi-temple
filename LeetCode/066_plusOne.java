class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int tmp = digits[i] + carry;
            digits[i] = tmp % 10;
            carry = tmp / 10;
        }
        if (carry == 0) {
            return digits;
        }
        int[] arr = new int[digits.length+1];
        arr[0] = 1;
        System.arraycopy(digits, 0, arr, 1, digits.length);
        return arr;
    }
}
