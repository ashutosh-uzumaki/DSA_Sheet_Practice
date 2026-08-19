package org.example.graphs.connected_components;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    numOfIslands+=1;
                    connectIslandHelper(i, j, grid);
                }
            }
        }

        return numOfIslands;
    }

    private void connectIslandHelper(int row, int col, char[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        connectIslandHelper(row - 1, col, grid);
        connectIslandHelper(row, col - 1, grid);
        connectIslandHelper(row + 1, col, grid);
        connectIslandHelper(row, col + 1, grid);
    }
}
