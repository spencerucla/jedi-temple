class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                	dfs(grid, visited, i, j);
                	numIslands++;
				}
            }
        }
        return numIslands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (visited[i][j])
            return;
        visited[i][j] = true;
        if (grid[i][j] == '0')
            return;
        if (i-1 >= 0)
            dfs(grid, visited, i-1, j);
        if (i+1 < grid.length)
            dfs(grid, visited, i+1, j);
        if (j-1 >= 0)
            dfs(grid, visited, i, j-1);
        if (j+1 < grid[i].length)
            dfs(grid, visited, i, j+1);
    }

	// no extra space, modify grid
    public int numIslands2(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length
				|| grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
