package org.example.dynamic_programming.partition_dp.combination_sums;

import java.util.*;

public class CombinationSum4Memorization {
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return countWays(nums, target);
    }

    private int countWays(int[] nums, int target){
        if(target == 0){
            return 1;
        }
        if(memo[target] != -1){
            return memo[target];
        }
        int ways = 0;
        for(int num: nums){
            if(num <= target){
                ways += countWays(nums, target - num);
            }
        }

        return memo[target] = ways;
    }
}
