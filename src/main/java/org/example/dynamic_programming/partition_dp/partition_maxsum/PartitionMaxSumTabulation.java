package org.example.dynamic_programming.partition_dp.partition_maxsum;

public class PartitionMaxSumTabulation {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for(int elements=1; elements<=n; elements++){
            int currMax = Integer.MIN_VALUE;
            for(int size=1; size<=Math.min(elements, k); size++){
                currMax = Math.max(arr[elements-size], currMax);
                int contri = currMax * size;
                dp[elements] = Math.max(contri + dp[elements - size], dp[elements]);
            }
        }

        return dp[n];
    }
}
