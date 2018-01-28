class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) return 1;
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    paths[i][j] = 1;
                } else {
                    int sum = 0;
                    if (i-1 >= 0)
                        sum += paths[i-1][j];
                    if (j-1 >= 0)
                        sum += paths[i][j-1];
                    paths[i][j] = sum;
                }
            }
        }
        return paths[m-1][n-1];
    }
}
