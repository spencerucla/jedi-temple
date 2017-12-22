class Solution {
    private static final int N = 9;
    public boolean isValidSudoku(char[][] board) {
        // check rows for dupes
        for (int i = 0; i < N; i++) {
            HashSet set = new HashSet<Character>();
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }
        // check cols for dupes
        for (int i = 0; i < N; i++) {
            HashSet set = new HashSet<Character>();
            for (int j = 0; j < N; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    } else {
                        set.add(board[j][i]);
                    }
                }
            }
        }
        // check squares for dupes
        // a, b are outer squares
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                // x, y are inner squares
                HashSet set = new HashSet<Character>();
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (board[a*3+x][b*3+y] != '.') {
                            if (set.contains(board[a*3+x][b*3+y])) {
                                return false;
                            } else {
                                set.add(board[a*3+x][b*3+y]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
