package org.example.recursion.basic;

public class Power {
    public double myPow(double x, int n) {
        if(n < 0){
            return 1 / pow(x, -n);
        }
        return pow(x, n);
    }

    private double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }

        double halfAns = pow(x, n/2);
        if(n % 2 == 0){
            return halfAns * halfAns;
        }
        return halfAns * halfAns * x;
    }
}
