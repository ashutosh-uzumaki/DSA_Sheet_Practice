package org.example.bit_manipulation.interview_problems;

public class FindTwoSingleNum {
    public int[] singleNumber(int[] nums) {
        int xorRes = 0;
        for(int num: nums){
            xorRes ^= num;
        }
        int setBit = xorRes & (-xorRes);
        int a = 0;
        int b = 0;
        for(int num: nums){
            if((num & setBit) == 0){
                a ^= num;
            }else{
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
