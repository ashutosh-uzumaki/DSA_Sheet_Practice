package org.example.dynamic_programming.coin_change_combinations;

public class CoinChangeCombinationsTabulation {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[n][0] = 1;

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int amt = 0; amt <= amount; amt++) {
                int skip = dp[idx + 1][amt];

                int take = 0;
                if (coins[idx] <= amt) {
                    take = dp[idx][amt - coins[idx]];
                }

                dp[idx][amt] = take + skip;
            }
        }

        return dp[0][amount];
    }
}
