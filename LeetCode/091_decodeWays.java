class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] arr = new int[s.length()];

        if (s.startsWith("0")) return 0;
        arr[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            char p = s.charAt(i-1);
            char c = s.charAt(i);
            if ((p == '1' || p == '2') && c == '0') {
                // 1-2, 0
                if (i-2 >= 0 && (s.charAt(i-2) == '1' || s.charAt(i-2) == '2')) {
                    // 1, 1-2, 0
                    // ex: 1212 = 5, but 12120 = 3 (same as if 121, so copy i-2
                    arr[i] = arr[i-2];
                } else {
                    // 3-9, 1-2, 0
                    arr[i] = arr[i-1];
                }
            } else if (!(p == '1' || p == '2') && c == '0') {
                // 3-9, 0
                return 0;
            } else if (p == '1' && !(c == '0')) {
                // 1, 1-9
                // arr[i] = arr[i-1] + arr[i-2];
                arr[i] = arr[i-1];
                if (i-2 >= 0)
                    arr[i] += arr[i-2];
                else
                    arr[i]++;
            } else if (p == '2' && !(c == '7' || c == '8' || c == '9')) {
                // 2, 1-6
                // arr[i] = arr[i-1] + arr[i-2];
                arr[i] = arr[i-1];
                if (i-2 >= 0)
                    arr[i] += arr[i-2];
                else
                    arr[i]++;
            } else if (p == '2' && (c == '7' || c == '8' || c == '9')) {
                // 2, 7-9
                arr[i] = arr[i-1];
            } else {
                // 3-9, 1-9
                arr[i] = arr[i-1];
            }
        }
        return arr[s.length()-1];
    }
}
