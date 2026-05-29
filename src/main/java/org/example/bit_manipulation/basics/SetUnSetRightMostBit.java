package org.example.bit_manipulation.basics;

public class SetUnSetRightMostBit {
    public int setBit(int n) {
        int result = 1;
        while((result & n) != 0){
            result = result << 1;
        }

        n = (n | result);
        return n;
    }
}
