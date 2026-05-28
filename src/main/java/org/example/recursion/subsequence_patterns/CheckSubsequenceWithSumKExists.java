package org.example.recursion.subsequence_patterns;

public class CheckSubsequenceWithSumKExists {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        return helper(0, arr, k);
    }

    private boolean helper(int idx, int[] arr, int k){
        if(k == 0){
            return true;
        }

        if(idx == arr.length || k < 0){
            return false;
        }

        boolean ans = false;

        for(int i=idx; i<arr.length; i++){
            if(arr[i] <= k){
                ans = ans || helper(i + 1, arr, k - arr[i]);
            }
        }
        return ans;
    }
}
