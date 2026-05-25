package org.example.arrays_easy;

public class LargestElement {
    public static int largest(int[] arr) {
        int largest = arr[0];
        for(int num: arr){
            largest = Math.max(largest, num);
        }
        return largest;
    }
}
