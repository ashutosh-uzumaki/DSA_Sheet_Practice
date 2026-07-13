package org.example.dynamic_programming.fibanocci.house_robber_two;

public class HouseRobberTwoRecursive {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[][] dp = new int[n+1][2];
        for(int i=0; i<=n; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        int withoutLast = robHouses(nums, 0, n-2, 0, dp);
        for(int i=0; i<=n; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        int withLast = robHouses(nums, 1, n-1, 0, dp);

        return Math.max(withoutLast, withLast);
    }

    public int robHouses(int[] nums, int idx, int n, int previous, int[][] dp){
        if(idx == n+1){
            return 0;
        }

        if(dp[idx][previous] != -1){
            return dp[idx][previous];
        }

        int select = (previous == 0) ? robHouses(nums, idx+1, n, 1, dp) + nums[idx] : 0;
        int notSelect = robHouses(nums, idx+1, n, 0, dp);

        return dp[idx][previous] = Math.max(select, notSelect);
    }
}
