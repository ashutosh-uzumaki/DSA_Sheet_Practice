package org.example.binary_search.on_answer;

public class SquareRoot {
    public int mySqrt(int x) {
        long low = 0;
        long high = (long)(1e9);
        int ans = 1;
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(mid * mid <= x){
                ans = (int) mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}
