package org.example.dynamic_programming.fibanocci.climb_stairs;

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
}
