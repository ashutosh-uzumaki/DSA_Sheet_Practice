package org.example.dynamic_programming.rod_cutting;

public class RodCuttingTabulation {
    public int cutRod(int[] price, int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int len = 0; len <= n; len++) {
                int doNotCut = dp[idx + 1][len];

                int cut = 0;
                int pieceLength = idx + 1;
                if (pieceLength <= len) {
                    cut = price[idx] + dp[idx][len - pieceLength];
                }

                dp[idx][len] = Math.max(cut, doNotCut);
            }
        }

        return dp[0][n];
    }
}
