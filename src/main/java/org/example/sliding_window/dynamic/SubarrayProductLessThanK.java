package org.example.sliding_window.dynamic;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int currProduct = 1;
        int left = 0;
        int right = 0;
        int n = nums.length;
        while(right < n){
            currProduct *= nums[right];
            while(left <= right && currProduct >= k){
                currProduct /= nums[left];
                left += 1;
            }
            count += (right - left + 1);
            right += 1;
        }

        return count;
    }
}
