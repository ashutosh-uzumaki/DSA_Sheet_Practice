package org.example.arrays_easy;

public class SecondLargestElement {
    public int getSecondLargest(int[] arr) {
        int largestElement = arr[0];
        int secondLargestElement = Integer.MIN_VALUE;

        for(int num: arr){
            if(num > largestElement){
                secondLargestElement = largestElement;
                largestElement = num;
            }else if(num > secondLargestElement && num != largestElement){
                secondLargestElement = num;
            }
        }
        return (secondLargestElement == Integer.MIN_VALUE ? -1 : secondLargestElement);
    }
}
