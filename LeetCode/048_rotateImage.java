class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // for half / half: 0,[0, n-1); 1,[1,n-2)
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {

                // swirl 4x
                int new_val = matrix[i][j], old_val;
                for (int k = 0; k < 4; k++) {
                    // need to save some i/j temps
                    int next_i = j;
                    int next_j = n - i - 1;
                    old_val = matrix[next_i][next_j];
                    matrix[next_i][next_j] = new_val;
                    new_val = old_val;
                    i = next_i;
                    j = next_j;
                }
            }
        }
    }
}
