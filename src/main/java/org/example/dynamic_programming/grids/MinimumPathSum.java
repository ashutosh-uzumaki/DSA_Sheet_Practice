package org.example.dynamic_programming.grids;

import java.util.*;

public class MinimumPathSum {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        memo = new int[grid.length + 1][grid[0].length + 1];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return helper(0, 0, grid);
    }
    private int helper(int i, int j, int[][] grid){
        if(i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int left = helper(i + 1, j, grid);
        int right = helper(i, j + 1, grid);

        return memo[i][j] = Math.min(left, right) + grid[i][j];
    }
}
