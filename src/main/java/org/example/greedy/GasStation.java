package org.example.greedy;

import java.util.*;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = Arrays.stream(cost).sum();
        int totalGas = Arrays.stream(gas).sum();

        if(totalGas < totalCost){
            return -1;
        }

        int startPlace = 0;
        int gasReq = 0;

        for(int i=0; i<cost.length; i++){
            gasReq += gas[i] - cost[i];
            if(gasReq < 0){
                startPlace = i + 1;
                gasReq = 0;
            }
        }

        return startPlace;
    }
}
