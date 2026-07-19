package org.example.dynamic_programming.partition_dp.integer_break;

import java.util.*;

public class IntegerBreakMemorization {
    int[] memo;
    public int integerBreak(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return maxProductFromBreak(n, memo);
    }

    private int maxProductFromBreak(int n, int[] memo){
        if(n == 1){
            return 1;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        int maxAnsFromBreak = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            int noFurtherBreak = i * (n-i);
            int breakFurther = i * maxProductFromBreak(n - i, memo);
            maxAnsFromBreak = Math.max(maxAnsFromBreak, Math.max(noFurtherBreak, breakFurther));
        }

        return memo[n] = maxAnsFromBreak;
    }
}
