package org.example.dynamic_programming.lcs;

import java.util.Arrays;

public class LongestCommonSubsequenceMemorization {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, text1, text2, memo);
    }

    private int helper(int i, int j, String text1, String text2, int[][] memo) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int result;
        if (text1.charAt(i) == text2.charAt(j)) {
            result = 1 + helper(i + 1, j + 1, text1, text2, memo);
        } else {
            int skipFirst = helper(i + 1, j, text1, text2, memo);
            int skipSecond = helper(i, j + 1, text1, text2, memo);
            result = Math.max(skipFirst, skipSecond);
        }

        return memo[i][j] = result;
    }
}
