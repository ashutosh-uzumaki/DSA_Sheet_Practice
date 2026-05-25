package org.example.arrays.medium;

public class MajorityElementOne {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int ele = -1;

        for(int i=0; i<nums.length; i++){
            if(cnt == 0){
                ele = nums[i];
            }
            if(ele == nums[i]){
                cnt += 1;
            }else{
                cnt -= 1;
            }
        }

        return ele;
    }
}
