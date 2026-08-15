package org.example.graphs.bfs;

import java.util.*;

public class SnakeAndLadder {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});
        boolean[] visited =  new boolean[n * n + 1];
        visited[1] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int cell = curr[0];
            int diceRollCnt =  curr[1];

            for(int roll=1; roll <= 6; roll++){
                int next = cell + roll;
                if(next > n * n) continue;
                int[] coords = convertCellToCords(next, n);
                int row = coords[0];
                int col = coords[1];

                if(board[row][col] != -1){
                    next = board[row][col];
                }
                if(next == n * n){
                    return diceRollCnt + 1;
                }
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(new int[]{next, diceRollCnt + 1});
                }
            }


        }
        return -1;
    }

    private int[] convertCellToCords(int cell, int n){
        int pos = cell - 1;
        int row = pos / n;
        int col = row % 2 == 0 ? pos % n : n - 1 - pos % n;
        return new int[]{n-1-row, col};
    }
}
