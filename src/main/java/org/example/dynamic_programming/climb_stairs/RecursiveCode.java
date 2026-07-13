package org.example.dynamic_programming.climb_stairs;

public class RecursiveCode {
    public int climbStairs(int n) {
        return countWays(n);
    }

    private int countWays(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        int waysWithStepOne = countWays(n - 1);
        int waysWithStepTwo = countWays(n - 2);

        return waysWithStepOne + waysWithStepTwo;
    }
}
