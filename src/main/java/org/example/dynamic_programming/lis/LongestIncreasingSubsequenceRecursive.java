package org.example.dynamic_programming.lis;

import java.util.*;

public class LongestIncreasingSubsequenceRecursive {
    int[][] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n + 1][n + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return helper(-1, 0, nums);
    }

    private int helper(int lastSelected, int idx, int[] nums) {
        if (idx >= nums.length) return 0;

        int shiftedLast = lastSelected + 1;
        if (memo[shiftedLast][idx] != -1) return memo[shiftedLast][idx];

        int skip = helper(lastSelected, idx + 1, nums);
        int choose = (lastSelected == -1 || nums[lastSelected] < nums[idx])
                ? 1 + helper(idx, idx + 1, nums) : 0;

        return memo[shiftedLast][idx] = Math.max(skip, choose);
    }
}
