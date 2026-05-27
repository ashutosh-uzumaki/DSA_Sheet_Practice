package org.example.recursion.subsequence_patterns;

import java.util.*;

public class GenerateAllSubset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        helper(0, new ArrayList<>(), subsets, nums);
        return subsets;
    }

    private void helper(int idx, List<Integer> curr, List<List<Integer>> subsets, int[] nums){
        subsets.add(new ArrayList<>(curr));

        for(int i=idx; i<nums.length; i++){
            curr.add(nums[i]);
            helper(i + 1, curr, subsets, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
