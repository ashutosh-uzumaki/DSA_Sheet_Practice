package org.example.dynamic_programming.grids;

public class LongestIncreasingPathInMatrix {
    int[][] memo;
    int rows;
    int cols;
    int[][] matrix;
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        memo = new int[rows + 1][cols + 1];
        this.matrix = matrix;
        int longestPath = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                longestPath = Math.max(longestPath, calculatePath(i, j));
            }
        }

        return longestPath;
    }

    public int calculatePath(int row, int col){
        if(memo[row][col] != 0){
            return memo[row][col];
        }

        int[] dirRow = {-1, 0, 1, 0};
        int[] dirCol = {0, -1, 0, 1};

        for(int i = 0; i < 4; i++){
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];

            if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[row][col]){
                memo[row][col] = Math.max(memo[row][col], calculatePath(newRow, newCol));
            }
        }

        return memo[row][col] += 1;
    }
}
