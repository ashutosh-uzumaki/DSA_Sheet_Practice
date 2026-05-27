package org.example.binary_search.on_answer;

import java.util.*;

public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(computeSum(mid, nums, threshold)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean computeSum(int divisor, int[] nums, int threshold){
        int sum = 0;
        for(int num: nums){
            sum += (num + divisor - 1) / divisor;
        }

        return sum <= threshold;
    }
}
