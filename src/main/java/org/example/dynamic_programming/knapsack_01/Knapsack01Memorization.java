package org.example.dynamic_programming.knapsack_01;

import java.util.Arrays;

public class Knapsack01Memorization {
    public int knapsack(int[] val, int[] wt, int capacity) {
        int[][] memo = new int[val.length][capacity + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(0, capacity, val, wt, memo);
    }

    private int helper(int idx, int capacity, int[] val, int[] wt, int[][] memo) {
        if (idx == val.length) {
            return 0;
        }
        if (memo[idx][capacity] != -1) {
            return memo[idx][capacity];
        }

        int skip = helper(idx + 1, capacity, val, wt, memo);

        int take = 0;
        if (wt[idx] <= capacity) {
            take = val[idx] + helper(idx + 1, capacity - wt[idx], val, wt, memo);
        }

        return memo[idx][capacity] = Math.max(take, skip);
    }
}
