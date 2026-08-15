package org.example.dynamic_programming.grids;

import java.util.*;

public class UniquePathsWithObstacle {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1){
            return 0;
        }
        int[][] memo = new int[rows][cols];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return helper(0, 0, rows, cols, obstacleGrid, memo);
    }

    private int helper(int row, int col, int rows, int cols, int[][] obstacleGrid, int[][] memo){
        if(row == rows - 1 && col == cols - 1){
            return 1;
        }
        if(row >= rows || col >= cols){
            return 0;
        }
        if(obstacleGrid[row][col] == 1){
            return 0;
        }

        if(memo[row][col] != -1){
            return memo[row][col];
        }

        return memo[row][col] = helper(row + 1, col, rows, cols, obstacleGrid, memo) + helper(row, col + 1, rows, cols, obstacleGrid, memo);
    }
}
