package org.example.arrays.medium;

import java.util.*;

public class TwoSumUnsorted {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int numToFind = target - nums[i];
            if(indices.containsKey(numToFind)){
                int j = indices.get(numToFind);
                return new int[]{i, j};
            }
            indices.put(nums[i], i);
        }
        return new int[0];
    }
}
