package org.example.dynamic_programming.climb_stairs;

import java.util.*;

public class MemorizationCode {
    private final HashMap<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        return countWays(n);
    }

    private int countWays(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int waysWithStepOne = countWays(n - 1);
        int waysWithStepTwo = countWays(n - 2);
        memo.put(n, waysWithStepOne + waysWithStepTwo);
        return waysWithStepOne + waysWithStepTwo;
    }

    public static class TabulationCode {
        public int climbStairs(int n) {
            int[] memo = new int[n + 1];
            memo[0] = 1;
            memo[1] = 1;

            for(int i=2; i<=n; i++){
                memo[i] = memo[i - 1] + memo[i - 2];
            }

            return memo[n];
        }
    }
}
