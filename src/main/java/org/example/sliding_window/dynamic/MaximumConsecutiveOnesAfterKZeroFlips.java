package org.example.sliding_window.dynamic;

public class MaximumConsecutiveOnesAfterKZeroFlips {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int longestLength = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int n = nums.length;

        while(right < n){
            count += nums[right] == 0 ? 1 : 0;

            while(count > k){
                count -= nums[left] == 0 ? 1 : 0;
                left += 1;
            }

            longestLength = Math.max(longestLength, right - left + 1);
            right += 1;
        }

        return longestLength;
    }
}
