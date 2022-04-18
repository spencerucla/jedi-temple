class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // enqueue all 0's as starting points
        // and preprocess matrix, setting all non-0 values to max
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // enqueue null to denote end of 0th distance
        queue.add(null);

        int dist = 0;
        while (queue.size() > 1) {
            int[] c = queue.poll();
            if (c != null) {
                updateAndEnqueue(mat, c[0]-1, c[1], queue, dist);
                updateAndEnqueue(mat, c[0]+1, c[1], queue, dist);
                updateAndEnqueue(mat, c[0], c[1]-1, queue, dist);
                updateAndEnqueue(mat, c[0], c[1]+1, queue, dist);
            } else {
                dist++;
                queue.add(null); // re-add to indicate next distance
            }
        }
        return mat;
    }

    private void updateAndEnqueue(int[][] mat, int r, int c, Queue<int[]> queue, int dist) {
        if (r >= 0 && r < mat.length && c >= 0 && c < mat[0].length) {
            int newVal = Math.min(mat[r][c], dist+1);
            if (newVal < mat[r][c]) {
                mat[r][c] = newVal;
                queue.add(new int[] { r, c });
            }
        }
    }
}
