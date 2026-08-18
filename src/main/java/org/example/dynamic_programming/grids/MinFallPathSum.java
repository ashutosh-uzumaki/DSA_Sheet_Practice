package org.example.dynamic_programming.grids;

public class MinFallPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        int minSum = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            minSum = Math.min(
                    minSum,
                    helper(0, col, matrix, dp, visited)
            );
        }

        return minSum;
    }

    private int helper(
            int row,
            int col,
            int[][] matrix,
            int[][] dp,
            boolean[][] visited) {

        if (row == matrix.length - 1) {
            return matrix[row][col];
        }

        if (visited[row][col]) {
            return dp[row][col];
        }

        int minSum = Integer.MAX_VALUE;

        for (int nextCol = col - 1; nextCol <= col + 1; nextCol++) {

            if (nextCol >= 0 && nextCol < matrix[0].length) {
                minSum = Math.min(
                        minSum,
                        helper(row + 1, nextCol, matrix, dp, visited)
                );
            }
        }

        visited[row][col] = true;

        return dp[row][col] =
                matrix[row][col] + minSum;
    }
}
