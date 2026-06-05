package org.example.sliding_window.fixed;

public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        long maxSum = Long.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(i >= k){
                sum -= nums[i - k];
            }
            sum += nums[i];
            if(i >= k-1){
                maxSum = Math.max(maxSum, sum);
            }
        }

        return (double)maxSum / k;
    }
}
