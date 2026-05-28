package org.example.recursion.subsequence_patterns;

import java.util.*;

public class CombinationSumWithSizeK {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        helper(1, 0, new ArrayList<>(), k, n);
        return ans;
    }

    private void helper(int val, int currSum, List<Integer> path, int k, int n){
        if(path.size() == k){
            if(currSum == n){
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i = val; i <= 9; i++){
            if(currSum + i > n){
                break;
            }
            path.add(i);
            helper(i + 1, currSum + i, path, k, n);
            path.remove(path.size() - 1);
        }
    }
}
