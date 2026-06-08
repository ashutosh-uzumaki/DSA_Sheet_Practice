package org.example.sliding_window.dynamic;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while(right < n){
            sum += nums[right];
            while(sum >= target){
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left += 1;
            }
            right += 1;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
