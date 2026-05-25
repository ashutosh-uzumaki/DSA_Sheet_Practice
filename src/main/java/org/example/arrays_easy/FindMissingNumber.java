package org.example.arrays_easy;

public class FindMissingNumber {
    int missingNum(int arr[]) {
        long sum = 0;
        long n = arr.length * 1l;
        n += 1;
        long totalSum = (n * (n + 1))/2;
        for(int num: arr){
            sum += (num * 1l);
        }
        int missing = (int)(totalSum - sum);
        return missing;
    }
}
