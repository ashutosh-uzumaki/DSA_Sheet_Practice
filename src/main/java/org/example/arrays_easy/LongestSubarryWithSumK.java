package org.example.arrays_easy;

import java.util.*;

public class LongestSubarryWithSumK {
    public int longestSubarray(int[] arr, int k) {
        int maxLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0, -1);
        int runningSum = 0;
        for(int i=0; i<arr.length; i++){
            runningSum += arr[i];
            if(prefixSum.containsKey(runningSum - k)){
                int idx = prefixSum.get(runningSum - k);
                maxLength = Math.max(maxLength, i - idx);
            }
            if(!prefixSum.containsKey(runningSum)){
                prefixSum.put(runningSum, i);
            }
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
