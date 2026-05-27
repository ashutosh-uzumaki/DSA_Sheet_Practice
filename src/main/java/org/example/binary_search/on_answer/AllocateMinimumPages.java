package org.example.binary_search.on_answer;

import java.util.*;

public class AllocateMinimumPages {
    public int findPages(int[] arr, int k) {
        if(k > arr.length){
            return -1;
        }
        int low = 1;
        int high = Arrays.stream(arr).sum();
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canAllocatePages(mid, arr, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canAllocatePages(int currPages, int[] arr, int k){
        int student = 1;
        int totalPages = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > currPages){
                return false;
            }
            if(totalPages + arr[i] > currPages){
                totalPages = arr[i];
                student += 1;
            }else{
                totalPages += arr[i];
            }
        }

        return student <= k;
    }
}
