class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int area = search(grid, i, j);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    private int search(int[][] grid, int sr, int sc) {
        if (sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[sr].length
                || grid[sr][sc] == 0)
            return 0;
        grid[sr][sc] = 0;
        int area = 1;
        area += search(grid, sr-1, sc);
        area += search(grid, sr+1, sc);
        area += search(grid, sr, sc-1);
        area += search(grid, sr, sc+1);
        return area;
    }
}
