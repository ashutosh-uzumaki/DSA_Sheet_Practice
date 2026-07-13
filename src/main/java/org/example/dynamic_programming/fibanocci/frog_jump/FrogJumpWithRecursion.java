package org.example.dynamic_programming.fibanocci.frog_jump;

import java.util.*;

public class FrogJumpWithRecursion {
    private final HashSet<Integer> stonePositions = new HashSet<>();
    public boolean canCross(int[] stones) {
        for(int stone: stones){
            stonePositions.add(stone);
        }
        if(!stonePositions.contains(1)){
            return false;
        }
        return checkCanCross(1, 1, stones);
    }

    private boolean checkCanCross(int lastJump, int currPos, int[] stones){
        if(currPos == stones[stones.length - 1]){
            return true;
        }

        if(currPos > stones[stones.length - 1]){
            return false;
        }


        for(int jump = lastJump-1; jump <= lastJump + 1; jump++){
            if(jump == 0 || !stonePositions.contains(jump + currPos)){
                continue;
            }
            if(checkCanCross(jump, currPos + jump, stones)){
                return true;
            }
        }

        return false;
    }
}
