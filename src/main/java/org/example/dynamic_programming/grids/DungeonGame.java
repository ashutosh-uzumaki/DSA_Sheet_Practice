package org.example.dynamic_programming.grids;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        return helper(0, 0, rows, cols, dungeon);
    }

    private int helper(int row, int col,
                       int rows, int cols,
                       int[][] dungeon) {

        if (row == rows - 1 && col == cols - 1) {
            return Math.max(1, 1 - dungeon[row][col]);
        }

        if (row >= rows || col >= cols) {
            return Integer.MAX_VALUE;
        }

        int right = helper(row, col + 1, rows, cols, dungeon);
        int down = helper(row + 1, col, rows, cols, dungeon);

        int nextRequired = Math.min(right, down);

        return Math.max(
                1,
                nextRequired - dungeon[row][col]
        );
    }
}
