package org.example.dynamic_programming.knapsack_01;

public class Knapsack01Tabulation {
    public int knapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int cap = 0; cap <= capacity; cap++) {
                int skip = dp[idx + 1][cap];

                int take = 0;
                if (wt[idx] <= cap) {
                    take = val[idx] + dp[idx + 1][cap - wt[idx]];
                }

                dp[idx][cap] = Math.max(take, skip);
            }
        }

        return dp[0][capacity];
    }
}
