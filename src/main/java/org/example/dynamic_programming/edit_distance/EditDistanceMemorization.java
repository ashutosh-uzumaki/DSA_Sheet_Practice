package org.example.dynamic_programming.edit_distance;

import java.util.Arrays;

public class EditDistanceMemorization {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, word1, word2, memo);
    }

    private int helper(int i, int j, String word1, String word2, int[][] memo) {
        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int result;
        if (word1.charAt(i) == word2.charAt(j)) {
            result = helper(i + 1, j + 1, word1, word2, memo);
        } else {
            int insert = 1 + helper(i, j + 1, word1, word2, memo);
            int delete = 1 + helper(i + 1, j, word1, word2, memo);
            int replace = 1 + helper(i + 1, j + 1, word1, word2, memo);
            result = Math.min(insert, Math.min(delete, replace));
        }

        return memo[i][j] = result;
    }
}
