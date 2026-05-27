package org.example.binary_search.on_answer;

import java.util.*;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canSplits(mid, nums, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canSplits(int boundary, int[] nums, int k){
        int split = 1;
        int sum = 0;
        for(int num: nums){
            if(num > boundary){
                return false;
            }
            if(sum + num > boundary){
                split += 1;
                sum = num;
            }else{
                sum += num;
            }
        }

        return split <= k;
    }
}
