package org.example.binary_search.on_answer;

public class NthRoot {
    public int nthRoot(int n, int m) {
        // code here
        long low = 0;
        long high = (long)m;
        int ans = -1;
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(check(mid, n*1l, m*1l)){
                ans = (int)mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        if(ans != -1 && power(ans, n*1l) == m){
            return (int)ans;
        }
        return -1;
    }

    private boolean check(long curr, long n, long m){
        long ans = 1;

        for(int i=1; i<=(int)n; i++){
            ans *= curr;
        }

        return ans <= m;
    }

    private long power(long base, long n){
        long ans = 1;
        for(int i=1; i<=(int)n; i++){
            ans *= base;
        }
        return ans;
    }
}
