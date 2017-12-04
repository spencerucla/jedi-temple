class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int left = 0, right = height.length - 1; left < right; ) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(area, max);
            // move smaller ptr looking for bigger wall with less height
            // because moving bigger ptr won't find anything bigger than curr max
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
