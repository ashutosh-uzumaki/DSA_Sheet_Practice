package org.example.dynamic_programming.fibanocci.house_placements;

public class CountHousePlacementsRecursive {
    private final int mod = (int)(1e9 + 7);
    public int countHousePlacements(int n) {
        int oneSidePlacementResult = housePlacementsHelper(n);
        return ((oneSidePlacementResult % mod * oneSidePlacementResult % mod) % mod);
    }

    private int housePlacementsHelper(int n){
        if(n == 0){
            return 1;
        }

        if(n == 1){
            return 2;
        }

        return (housePlacementsHelper(n - 1) % mod + housePlacementsHelper(n - 2) % mod) % mod;
    }
}
