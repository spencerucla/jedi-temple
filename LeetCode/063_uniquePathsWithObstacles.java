class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m <= 1 && n == 0) return 1;
        if (m <= 1 && n <= 1) return (obstacleGrid[0][0] == 0) ? 1 : 0;
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    paths[0][0] = 1;
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
