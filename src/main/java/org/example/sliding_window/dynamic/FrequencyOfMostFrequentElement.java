package org.example.sliding_window.dynamic;

import java.util.*;

public class FrequencyOfMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int maxLength = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while((long)nums[right] * (right - left + 1) - sum > k){
                sum -= nums[left];
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
        }
        return maxLength;
    }
}
