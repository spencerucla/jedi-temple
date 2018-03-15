class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                search(grid, visited, i, j);
                numIslands++;}
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
            search(grid, visited, i-1, j);
        if (i+1 < grid.length)
            search(grid, visited, i+1, j);
        if (j-1 >= 0)
            search(grid, visited, i, j-1);
        if (j+1 < grid[i].length)
            search(grid, visited, i, j+1);
    }
}
