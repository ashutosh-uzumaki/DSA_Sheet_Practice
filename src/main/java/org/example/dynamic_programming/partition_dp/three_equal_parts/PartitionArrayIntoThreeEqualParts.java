package org.example.dynamic_programming.partition_dp.three_equal_parts;

import java.util.*;

public class PartitionArrayIntoThreeEqualParts {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
        if(totalSum % 3 != 0){
            return false;
        }
        int target = totalSum / 3;

        int partsFound = 0;
        int runningSum = 0;
        for(int i=0; i<arr.length; i++){
            runningSum += arr[i];
            if(runningSum == target){
                partsFound += 1;
                runningSum = 0;
                if(partsFound == 2 && i < arr.length - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
