package org.example.recursion.subsequence_patterns;

import java.util.*;

public class UniqueSubsets {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, new ArrayList<>(), nums);
        return ans;
    }

    private void helper(int idx, List<Integer> path, int[] nums){
        ans.add(new ArrayList<>(path));

        for(int i=idx; i<nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]){
                continue;
            }
            path.add(nums[i]);
            helper(i + 1, path, nums);
            path.remove(path.size() - 1);
        }
    }
}
