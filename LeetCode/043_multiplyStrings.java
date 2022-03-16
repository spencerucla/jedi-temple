class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] nums = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int idx1 = i + j, idx2 = i + j + 1;
                int sum = mult + nums[idx2];

                nums[idx1] += sum / 10;
                nums[idx2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : nums) if (!(sb.length() == 0 && x == 0)) sb.append(x);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
