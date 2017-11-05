// https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int sum(List<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int i, int j) {
        if (matrix[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        List<Integer> rets = new ArrayList<Integer>();
        if (i-1 >= 0 && j-1 >= 0) {
            rets.add(dfs(matrix, visited, i-1, j-1));
        }
        if (i-1 >= 0) {
            rets.add(dfs(matrix, visited, i-1, j));
        }
        if (i-1 >= 0 && j+1 < matrix[i].length) {
            rets.add(dfs(matrix, visited, i-1, j+1));
        }
        if (j-1 >= 0) {
            rets.add(dfs(matrix, visited, i, j-1));
        }
        if (j+1 < matrix[i].length) {
            rets.add(dfs(matrix, visited, i, j+1));
        }
        if (i+1 < matrix.length && j-1 >= 0) {
            rets.add(dfs(matrix, visited, i+1, j-1));
        }
        if (i+1 < matrix.length) {
            rets.add(dfs(matrix, visited, i+1, j));
        }
        if (i+1 < matrix.length && j+1 < matrix[i].length) {
            rets.add(dfs(matrix, visited, i+1, j+1));
        }
        return 1 + sum(rets);
    }

    public static int getBiggestRegion(int[][] matrix) {
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                int ret = dfs(matrix, visited, i, j);
                if (ret > max) {
                    max = ret;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
