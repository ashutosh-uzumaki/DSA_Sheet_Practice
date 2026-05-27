package org.example.binary_search.on_answer;

public class KthMissingPositive {
    public int findKthPositive(int[] arr, int k) {
        int low = 1;
        int high = arr[arr.length - 1] + k;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(possibleCandidate(mid, arr, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean possibleCandidate(int target, int[] arr, int k){
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
        int missingCandidates = target - low;
        return missingCandidates >= k;
    }
}
