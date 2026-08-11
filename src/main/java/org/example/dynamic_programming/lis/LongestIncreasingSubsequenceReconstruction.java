package org.example.dynamic_programming.lis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequenceReconstruction {
    public List<Integer> printLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = -1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (maxIdx != -1) {
            result.add(nums[maxIdx]);
            maxIdx = parent[maxIdx];
        }

        Collections.reverse(result);
        return result;
    }
}
