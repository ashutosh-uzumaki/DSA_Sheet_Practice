package org.example.binary_search.on_answer;

import java.util.*;

public class PaintersPartition {
    public int minTime(int[] arr, int k) {
        // code here
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canPaint(mid, arr, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canPaint(int time, int[] arr, int k){
        int painters = 1;
        int timeTaken = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > time){
                return false;
            }
            if(timeTaken + arr[i] > time){
                timeTaken = arr[i];
                painters += 1;
            }else{
                timeTaken += arr[i];
            }
        }

        return painters <= k;
    }
}
