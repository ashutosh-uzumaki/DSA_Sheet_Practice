package org.example.binary_search.on_answer;

import java.util.*;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] arr, int h) {
        long low = 1l;
        long[] piles = Arrays.stream(arr).asLongStream().toArray();
        long high = Arrays.stream(piles).max().getAsLong();
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(canEat(mid, piles, h)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return (int)low;
    }

    private boolean canEat(long speed, long[] piles, int h){
        long hour = 0;
        for(long pile: piles){
            hour += (pile + speed - 1) / speed;
        }

        return hour <= h;
    }
}
