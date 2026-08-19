package org.example.dynamic_programming.knapsack_unbounded;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return helper(target, memo, nums);
    }

    private int helper(int target, int[] memo, int[] nums){
        if(target == 0){
            return 1;
        }

        if(target < 0){
            return 0;
        }

        if(memo[target] != -1){
            return memo[target];
        }

        int cnt = 0;
        for(int num: nums){
            cnt += helper(target - num, memo, nums);
        }

        return memo[target] = cnt;
    }
}
