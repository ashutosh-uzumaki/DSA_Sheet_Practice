package org.example.sliding_window.dynamic;

import java.util.*;

public class MaxCardPointsRemovedFromFrontBack {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int windowSize = n - k;
        int totalSum = 0;
        int minSum = Integer.MAX_VALUE;
        totalSum = Arrays.stream(nums).sum();
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            if(i >= windowSize){
                sum -= nums[i - windowSize];
            }

            if(i >= windowSize - 1){
                minSum = Math.min(minSum, sum);
            }
        }

        return totalSum - minSum;
    }
}

//windowsize = n - k as k elements need to be selected
//remove the min sum of all the windows of windowsize and do totalSum - minSum to get maxSum
