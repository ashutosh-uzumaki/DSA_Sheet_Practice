package org.example.binary_search.on_answer;

public class CapacityToShipPackageWithinKDays {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = 0;
        for(int weight: weights){
            high += weight;
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canShipPackage(mid, weights, days)){
                high = mid - 1;
            }else
            {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canShipPackage(int curr, int[] weights, int days){
        int daysReq = 1;
        int totalWeight = 0;
        for(int weight: weights){
            if(weight > curr){
                return false;
            }
            if(totalWeight + weight > curr){
                totalWeight = weight;
                daysReq += 1;
            }else{
                totalWeight += weight;
            }
        }

        return daysReq <= days;
    }
}
