package org.example.dynamic_programming.coin_change_minimum;

public class CoinChangeMinimumTabulation {
    private static final int INF = 1_000_000;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int amt = 1; amt <= amount; amt++) {
            dp[n][amt] = INF;
        }

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int amt = 0; amt <= amount; amt++) {
                int skip = dp[idx + 1][amt];

                int take = INF;
                if (coins[idx] <= amt) {
                    take = 1 + dp[idx][amt - coins[idx]];
                }

                dp[idx][amt] = Math.min(take, skip);
            }
        }

        int result = dp[0][amount];
        return result >= INF ? -1 : result;
    }
}
