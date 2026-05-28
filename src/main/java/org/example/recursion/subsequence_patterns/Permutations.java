package org.example.recursion.subsequence_patterns;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        Arrays.sort(nums);
        helper(0, used, new ArrayList<Integer>(), ans, nums);
        return ans;
    }

    private void helper(int idx, boolean[] used, List<Integer> path, List<List<Integer>> ans, int[] nums){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            helper(i + 1, used, path, ans, nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
