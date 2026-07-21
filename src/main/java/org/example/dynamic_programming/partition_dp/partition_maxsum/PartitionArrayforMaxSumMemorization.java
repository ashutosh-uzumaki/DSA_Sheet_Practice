package org.example.dynamic_programming.partition_dp.partition_maxsum;

import java.util.*;

public class PartitionArrayforMaxSumMemorization {
    int[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        memo = new int[arr.length + 1];
        Arrays.fill(memo, -1);
        return maxPartitionSum(arr.length, arr, k);
    }

    private int maxPartitionSum(int n, int[] arr, int k){
        if(n == 0){
            return 0;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        int maxSum = Integer.MIN_VALUE;
        int currMax = Integer.MIN_VALUE;
        for(int size=1; size<=Math.min(n, k); size++){
            currMax = Math.max(arr[n - size], currMax);
            int contri = currMax * size;
            int total = contri + maxPartitionSum(n - size, arr, k);
            maxSum = Math.max(maxSum, total);
        }

        return memo[n] = maxSum;
    }
}
