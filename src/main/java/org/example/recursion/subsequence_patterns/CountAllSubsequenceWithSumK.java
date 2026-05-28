package org.example.recursion.subsequence_patterns;

public class CountAllSubsequenceWithSumK {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return helper(0, nums, k);
    }

    private int helper(int idx, int[] nums, int k){
        if(k == 0){
            return 1;
        }

        if(idx == nums.length || k < 0){
            return 0;
        }

        int ans = 0;
        for(int i=idx; i<nums.length; i++){
            if(nums[i] <= k){
                ans += helper(i + 1, nums, k - nums[i]);
            }
        }

        return ans;
    }
}
