package org.example.dynamic_programming.longest_mountain;

public class MinimumRemovalLongestMountain {
    public int minimumMountainRemovals(int[] nums) {
        int size = nums.length;
        if(size < 3){
            return Integer.MIN_VALUE;
        }
        int[] lis = new int[size];
        int[] dis = new int[size];

        for(int i=0; i<nums.length; i++){
            lis[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }

        for(int i=size-1; i>=0; i--){
            dis[i] = 1;
            for(int j=size-1; j>i; j--){
                if(nums[i] > nums[j]){
                    dis[i] = Math.max(dis[i], 1 + dis[j]);
                }
            }
        }

        int maxMountainFormed = Integer.MIN_VALUE;
        for(int i=1; i<size; i++){
            if(lis[i] > 1 && dis[i] > 1){
                int currLength = lis[i] + dis[i] - 1;
                maxMountainFormed = Math.max(currLength, maxMountainFormed);
            }
        }

        return size - maxMountainFormed;
    }
}
