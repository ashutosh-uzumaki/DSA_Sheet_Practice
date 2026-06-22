package org.example.greedy;

import java.util.*;

public class AppleRedistribution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApples = 0;
        for(int i=0; i<apple.length; i++){
            totalApples += apple[i];
        }

        int cnt = 0;
        int idx = capacity.length - 1;
        while(totalApples > 0){
            totalApples -= capacity[idx];
            idx -= 1;
            cnt += 1;
        }

        return cnt;
    }
}
