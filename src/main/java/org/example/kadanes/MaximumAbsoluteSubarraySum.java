package org.example.kadanes;

public class MaximumAbsoluteSubarraySum {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int currMin = nums[0];
        int currMax = nums[0];
        for(int i=1; i<nums.length; i++){
            currMin = Math.min(nums[i], nums[i] + currMin);
            currMax = Math.max(nums[i], nums[i] + currMax);

            minSum = Math.min(currMin, minSum);
            maxSum = Math.max(currMax, maxSum);
        }


        return Math.max(maxSum, Math.abs(minSum));
    }
}
