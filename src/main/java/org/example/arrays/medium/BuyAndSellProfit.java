package org.example.arrays.medium;

public class BuyAndSellProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length - 1;
        int maxSell = prices[n];
        for(int i=n; i>=0; i--){
            maxSell = Math.max(maxSell, prices[i]);
            profit = Math.max(profit, maxSell - prices[i]);
        }

        return profit;
    }
}
