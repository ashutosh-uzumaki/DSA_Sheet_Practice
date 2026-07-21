package org.example.dynamic_programming.partition_dp.combination_sums;

public class CombinationSumTabulation {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int t=1; t<=target; t++){
            for(int num: nums){
                if(num <= t){
                    dp[t] += dp[t - num];
                }
            }
        }

        return dp[target];
    }
}
