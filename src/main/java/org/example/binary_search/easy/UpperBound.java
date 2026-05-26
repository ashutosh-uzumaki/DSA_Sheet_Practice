package org.example.binary_search.easy;

public class UpperBound {
    int upperBound(int[] arr, int target) {
        // code here
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] <= target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}
