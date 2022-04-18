class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (!hasFresh(grid)) return 0;

        // enqueue each rotten orange
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }
        queue.add(null);

        int numMinutes = 0;
        boolean somethingRotted = false;
        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            if (c != null) {
                somethingRotted |= rot(grid, c[0]-1, c[1], queue);
                somethingRotted |= rot(grid, c[0]+1, c[1], queue);
                somethingRotted |= rot(grid, c[0], c[1]-1, queue);
                somethingRotted |= rot(grid, c[0], c[1]+1, queue);
            } else {
                numMinutes++;

                if (!hasFresh(grid)) return numMinutes;

                if (!somethingRotted) return -1;

                somethingRotted = false;
                queue.add(null);
            }
        }
        return 0; // unreachable

    }

    private boolean rot(int[][] grid, int r, int c, Queue<int[]> q) {
        // if in bounds, rot and enqueue
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
            grid[r][c] = 2;
            q.add(new int[] { r, c });
            return true;
        }
        return false;
    }

    private boolean hasFresh(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
