package org.example.dynamic_programming.coin_change_combinations;

import java.util.Arrays;

public class CoinChangeCombinationsMemorization {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(0, amount, coins, memo);
    }

    private int helper(int idx, int amount, int[] coins, int[][] memo) {
        if (amount == 0) {
            return 1;
        }
        if (idx == coins.length) {
            return 0;
        }
        if (memo[idx][amount] != -1) {
            return memo[idx][amount];
        }

        int skip = helper(idx + 1, amount, coins, memo);

        int take = 0;
        if (coins[idx] <= amount) {
            take = helper(idx, amount - coins[idx], coins, memo);
        }

        return memo[idx][amount] = take + skip;
    }
}
