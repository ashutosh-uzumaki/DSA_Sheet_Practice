package org.example.dynamic_programming.lis;

public class LongestIncreasingSubsequenceTabulation {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[]lis = new int[n];
        for(int i=0; i<nums.length; i++){
            lis[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(lis[i], max);
        }
        return max;
    }
}
