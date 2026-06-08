package org.example.sliding_window.dynamic;

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return countSubarrays(nums, k) - countSubarrays(nums, k-1);
    }

    private int countSubarrays(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = 0;
        int count = 0;
        int oddCount = 0;
        while(right < n){
            oddCount += (nums[right] % 2 == 1) ? 1 : 0;

            while(oddCount > target){
                oddCount -= (nums[left] % 2 == 1) ? 1 : 0;
                left += 1;
            }

            count += (right - left + 1);
            right += 1;
        }

        return count;
    }
}
