package org.example.greedy.jumps;

public class JumpTwo {
    public int jump(int[] nums) {
        int currentEnd = 0;
        int maxReach = 0;
        int jumpsRequired = 0;
        for(int i=0; i<nums.length - 1; i++){
            maxReach = Math.max(i + nums[i], maxReach);
            if(i == currentEnd){
                jumpsRequired += 1;
                currentEnd = maxReach;
            }
        }

        return jumpsRequired;
    }
}
