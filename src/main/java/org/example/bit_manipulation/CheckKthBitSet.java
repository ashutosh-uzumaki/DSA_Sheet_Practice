package org.example.bit_manipulation;

public class CheckKthBitSet {
    static boolean checkKthBit(int n, int k) {
        return ((1 << k) & n) != 0;
    }
}
