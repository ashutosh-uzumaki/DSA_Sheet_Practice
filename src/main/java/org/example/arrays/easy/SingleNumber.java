package org.example.arrays.easy;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int curr: nums){
            num ^= curr;
        }
        return num;
    }
}
