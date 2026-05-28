package org.example.recursion.subsequence_patterns;

import java.util.*;

public class AllSubsetSum {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> sum = new ArrayList<>();
        helper(0, 0, nums, sum);
        return sum;
    }

    private void helper(int idx, int curr, int[] nums, List<Integer> sum){
        sum.add(curr);
        for(int i=idx; i<nums.length; i++){
            helper(i + 1, curr + nums[i], nums, sum);
        }
    }
}
