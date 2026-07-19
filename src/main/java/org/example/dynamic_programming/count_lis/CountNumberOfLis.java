package org.example.dynamic_programming.count_lis;

public class CountNumberOfLis {
    public int findNumberOfLIS(int[] nums) {
        int size = nums.length;
        int[] count = new int[size];
        int[] lis = new int[size];
        int maxLen = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            lis[i] = 1;
            count[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    int cand = lis[j] + 1;
                    if(cand > lis[i]){
                        lis[i] = cand;
                        count[i] = count[j];
                    }else if(cand == lis[i]){
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, lis[i]);
        }

        int totalLisCount = 0;
        for(int i=0; i<size; i++){
            if(lis[i] == maxLen){
                totalLisCount += count[i];
            }
        }

        return totalLisCount;
    }
}
