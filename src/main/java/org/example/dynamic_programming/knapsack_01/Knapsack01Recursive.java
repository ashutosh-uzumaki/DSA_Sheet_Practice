package org.example.dynamic_programming.knapsack_01;

public class Knapsack01Recursive {
    public int knapsack(int[] val, int[] wt, int capacity) {
        return helper(0, capacity, val, wt);
    }

    private int helper(int idx, int capacity, int[] val, int[] wt) {
        if (idx == val.length) {
            return 0;
        }

        int skip = helper(idx + 1, capacity, val, wt);

        int take = 0;
        if (wt[idx] <= capacity) {
            take = val[idx] + helper(idx + 1, capacity - wt[idx], val, wt);
        }

        return Math.max(take, skip);
    }
}
