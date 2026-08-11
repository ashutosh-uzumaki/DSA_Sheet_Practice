package org.example.dynamic_programming.max_sum_increasing_subsequence;

public class MaximumSumIncreasingSubsequenceTabulation {
    public int maxSumIS(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n];
        int maxSum = arr[0];

        for (int i = 0; i < n; i++) {
            sum[i] = arr[i];

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    sum[i] = Math.max(sum[i], sum[j] + arr[i]);
                }
            }

            maxSum = Math.max(maxSum, sum[i]);
        }

        return maxSum;
    }
}
