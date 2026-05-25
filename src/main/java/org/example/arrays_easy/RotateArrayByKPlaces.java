package org.example.arrays_easy;

public class RotateArrayByKPlaces {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotateHelper(nums, 0, n-1);
        rotateHelper(nums, 0, k-1);
        rotateHelper(nums, k, n-1);
    }

    private void rotateHelper(int[] nums, int start, int end){
        while(start <= end){
            swap(nums, start, end);
            start += 1;
            end -= 1;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
