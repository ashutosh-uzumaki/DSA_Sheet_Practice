package org.example.arrays_easy;

public class MoveZerosToEnd {
    public void moveZeroes(int[] nums) {
        // int i = 0;
        // while(i < nums.length){
        //     if(nums[i] == 0){
        //         int j = i + 1;
        //         while(j < nums.length && nums[j] == 0){
        //             j++;
        //         }
        //         if(j >= nums.length){
        //             return;
        //         }
        //         if(nums[j] != 0){
        //             int temp = nums[i];
        //             nums[i] = nums[j];
        //             nums[j] = temp;
        //         }
        //     }
        //     i += 1;
        // }
        int insertPos = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[insertPos++] = nums[i];
            }
        }
        while(insertPos < nums.length){
            nums[insertPos++] = 0;
        }
    }
}
