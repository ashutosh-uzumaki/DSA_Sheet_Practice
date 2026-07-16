package org.example.dynamic_programming.lis;

import java.util.*;

public class LongestIncreasingSubsequenceBinarySearch {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        int size = nums.length;
        for(int i=0; i<size; i++){
            int idx = Collections.binarySearch(tails, nums[i]);
            if(idx < 0){
                idx = -(idx + 1);
            }
            if(idx == tails.size()){
                tails.add(nums[i]);
            }else{
                tails.set(idx, nums[i]);
            }
        }
        return tails.size();
    }
}
