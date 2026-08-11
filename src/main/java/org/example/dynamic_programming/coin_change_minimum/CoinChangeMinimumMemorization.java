package org.example.dynamic_programming.coin_change_minimum;

import java.util.Arrays;

public class CoinChangeMinimumMemorization {
    private static final int INF = 1_000_000;

    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int result = helper(0, amount, coins, memo);
        return result >= INF ? -1 : result;
    }

    private int helper(int idx, int amount, int[] coins, int[][] memo) {
        if (amount == 0) {
            return 0;
        }
        if (idx == coins.length) {
            return INF;
        }
        if (memo[idx][amount] != -1) {
            return memo[idx][amount];
        }

        int skip = helper(idx + 1, amount, coins, memo);

        int take = INF;
        if (coins[idx] <= amount) {
            take = 1 + helper(idx, amount - coins[idx], coins, memo);
        }

        return memo[idx][amount] = Math.min(take, skip);
    }
}
