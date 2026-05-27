package org.example.binary_search.on_answer;

import java.util.*;

public class AggressiveCows {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canPlaceCows(mid, stalls, k)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean canPlaceCows(int dist, int[] stalls, int k){
        int lastPos = stalls[0];
        int cowsPlaced = 1;
        for(int i=1; i<stalls.length; i++){
            if(stalls[i] - lastPos >= dist){
                lastPos = stalls[i];
                cowsPlaced += 1;
            }
        }

        return cowsPlaced >= k;
    }
}
