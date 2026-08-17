package org.example.dynamic_programming.grids;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }

        int maxSide = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                maxSide = Math.max(
                        maxSide,
                        helper(i, j, rows, cols, matrix, memo)
                );
            }
        }
        return maxSide * maxSide;
    }

    private int helper(int row, int col, int rows, int cols, char[][] matrix, int[][] memo){
        if(row < 0 || col < 0){
            return 0;
        }

        if(matrix[row][col] == '0'){
            return 0;
        }

        if(memo[row][col] != -1){
            return memo[row][col];
        }

        int up = helper(row - 1, col, rows, cols, matrix, memo);
        int left = helper(row, col - 1, rows, cols, matrix, memo);
        int diagonal = helper(row - 1, col - 1, rows, cols, matrix, memo);

        return memo[row][col] = 1 + Math.min(up, Math.min(left, diagonal));
    }
}
