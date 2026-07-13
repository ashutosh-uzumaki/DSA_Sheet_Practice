package org.example.dynamic_programming.fibanocci.house_robber_two;

public class HouseRobberTwoTabulation {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int withoutLast  = robRange(nums, 0, n - 2);
        int withoutFirst = robRange(nums, 1, n - 1);

        return Math.max(withoutLast, withoutFirst);
    }

    private int robRange(int[] nums, int start, int end) {
        if (start > end) return 0;      // empty range, e.g. n == 2 case
        int len = end - start + 1;
        int[] dp = new int[len];

        dp[0] = nums[start];
        if (len > 1) {
            dp[1] = Math.max(nums[start], nums[start + 1]);
        }

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start + i]);
        }

        return dp[len - 1];
    }
}
