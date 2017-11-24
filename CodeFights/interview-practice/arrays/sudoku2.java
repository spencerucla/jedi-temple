boolean sudoku2(char[][] grid) {
    boolean[] nums = new boolean[9];
    // check rows
    for (int i = 0; i < grid.length; i++) {
        Arrays.fill(nums, false);
        for (int j = 0; j < grid[i].length; j++) {
            int val = grid[i][j] - '1';
            if (val < 0) // '.'
                continue;
            if (nums[val])
                return false;
            nums[val] = true;
        }
    }
    // check cols
    for (int i = 0; i < grid[0].length; i++) {
        Arrays.fill(nums, false);
        for (int j = 0; j < grid.length; j++) {
            int val = grid[j][i] - '1';
            if (val < 0) // '.'
                continue;
            if (nums[val])
                return false;
            nums[val] = true;
        }
    }
    // check 3x3 squares
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            Arrays.fill(nums, false);
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    int val = grid[3*i+k][3*j+l] - '1';
                    if (val < 0) // '.'
                        continue;
                    if (nums[val])
                        return false;
                    nums[val] = true;
                }
            }
        }
    }
    return true;

}

