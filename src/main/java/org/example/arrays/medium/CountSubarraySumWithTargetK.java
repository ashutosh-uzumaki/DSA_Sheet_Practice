package org.example.arrays.medium;

import java.util.*;

public class CountSubarraySumWithTargetK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int runningSum = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            runningSum += nums[i];
            int target = runningSum - k;
            if(prefixSum.containsKey(target)){
                int currCount = prefixSum.get(target);
                count += currCount;
            }

            prefixSum.put(runningSum, prefixSum.getOrDefault(runningSum, 0) + 1);
        }

        return count;
    }
}
