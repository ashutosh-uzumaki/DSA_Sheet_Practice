package org.example.recursion.subsequence_patterns;

import java.util.*;

public class CombinationSum {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        helper(0, 0, new ArrayList<Integer>(), candidates, target);
        return ans;
    }

    private void helper(int idx, int currSum, List<Integer> path, int[] candidates, int target){
        if(currSum > target){
            return;
        }
        if(currSum == target){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx; i<candidates.length; i++){
            path.add(candidates[i]);
            helper(i, currSum + candidates[i], path, candidates, target);
            path.remove(path.size() - 1);
        }
    }
}
