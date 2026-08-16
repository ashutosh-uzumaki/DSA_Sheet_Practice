package org.example.dynamic_programming.grids;

import java.util.*;

public class TriangleMinPathSum {
    List<List<Integer>> triangle;
    int n;
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        n = triangle.size();
        dp = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0);
    }

    public int helper(int i, int j){
        if(i == n-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int downPath = triangle.get(i).get(j) + helper(i+1, j);
        int diagonalPath = triangle.get(i).get(j) + helper(i + 1, j + 1);

        return dp[i][j] = Math.min(downPath, diagonalPath);
    }
}
