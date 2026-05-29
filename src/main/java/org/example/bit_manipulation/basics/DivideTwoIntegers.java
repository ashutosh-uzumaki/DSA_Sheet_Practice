package org.example.bit_manipulation.basics;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long count = 0;

        while (dvd >= dvs) {
            long temp = dvs;
            long multiple = 1;
            long prevTemp = dvs;
            long prevMultiple = 1;

            while (temp > 0 && dvd >= temp) {
                prevTemp = temp;
                prevMultiple = multiple;
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= prevTemp;
            count += prevMultiple;
        }

        return (int)(negative ? -count : count);
    }
}
