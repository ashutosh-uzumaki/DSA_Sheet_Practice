package org.example.sliding_window.fixed;

import java.util.*;

public class MaxSubarraySumOfDistinctSizeK {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long sum = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if(i >= k){
                sum -= nums[i - k];
                int val = freq.get(nums[i - k]);
                val -= 1;
                if(val == 0){
                    freq.remove(nums[i - k]);
                }else{
                    freq.put(nums[i - k], val);
                }
            }

            if(i >= k - 1 && freq.size() == k){
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}
