package org.example.dynamic_programming.rod_cutting;

import java.util.Arrays;

public class RodCuttingMemorization {
    public int cutRod(int[] price, int n) {
        int[][] memo = new int[n][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(0, n, price, memo);
    }

    private int helper(int idx, int remainingLength, int[] price, int[][] memo) {
        if (idx == price.length) {
            return 0;
        }
        if (memo[idx][remainingLength] != -1) {
            return memo[idx][remainingLength];
        }

        int doNotCut = helper(idx + 1, remainingLength, price, memo);

        int cut = 0;
        int pieceLength = idx + 1;
        if (pieceLength <= remainingLength) {
            // idx does NOT advance, this piece length can be reused
            cut = price[idx] + helper(idx, remainingLength - pieceLength, price, memo);
        }

        return memo[idx][remainingLength] = Math.max(cut, doNotCut);
    }
}
