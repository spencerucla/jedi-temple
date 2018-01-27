class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m-1, j = n-1; i >= 0 || j >= 0; /* done in below loop */) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[i+j+1] = nums1[i];
                    i--;
                } else {
                    nums1[i+j+1] = nums2[j];
                    j--;
                }
            } else if (i >= 0) {    // ran out of j
                nums1[i+j+1] = nums1[i];
                i--;
            } else { // (j >= 0)    // ran out of i
                nums1[i+j+1] = nums2[j];
                j--;
            }
        }
    }
}
