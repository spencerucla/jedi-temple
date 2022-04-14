class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j]) {
                    int area = search(grid, i, j, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int search(int[][] grid, int sr, int sc, boolean[][] visited) {
        if (sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[sr].length
                || grid[sr][sc] == 0 || visited[sr][sc])
            return 0;
        visited[sr][sc] = true;
        int area = 1;
        area += search(grid, sr-1, sc, visited);
        area += search(grid, sr+1, sc, visited);
        area += search(grid, sr, sc-1, visited);
        area += search(grid, sr, sc+1, visited);
        return area;
    }
}
