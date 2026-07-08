package org.example.dynamic_programming.fibanocci.house_placements;

public class CountHousePlacementsMemorization {
    private final int mod = (int)(1e9 + 7);
    private final HashMap<Integer, Long> memo = new HashMap<>();
    public int countHousePlacements(int n) {
        long oneSidePlacementResult = housePlacementsHelper(n);
        return (int)((oneSidePlacementResult % mod * oneSidePlacementResult % mod) % mod);
    }

    private long housePlacementsHelper(int n){
        if(n == 0){
            return 1;
        }

        if(n == 1){
            return 2;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        long previousPlotPlacement = housePlacementsHelper(n - 1);
        long previousToPreviousPlotPlacement = housePlacementsHelper(n - 2);

        long currPlotPlacements = ((previousPlotPlacement % mod) + (previousToPreviousPlotPlacement % mod)) % mod;

        memo.put(n, currPlotPlacements);
        return currPlotPlacements;
    }
}
