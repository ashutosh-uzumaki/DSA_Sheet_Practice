package org.example.dynamic_programming.longest_continuous_subsequence;

public class LongestIncreasingContinuousSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int longest = 1;
        int count = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i - 1]){
                count += 1;
            }else{
                longest = Math.max(count, longest);
                count = 1;
            }
        }

        return Math.max(count, longest);
    }
}
