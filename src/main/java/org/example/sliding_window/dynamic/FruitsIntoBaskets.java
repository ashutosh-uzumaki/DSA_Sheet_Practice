package org.example.sliding_window.dynamic;

import java.util.*;

public class FruitsIntoBaskets {
    public int totalFruit(int[] fruits) {
        return maxFruits(fruits, 2);
    }

    private int maxFruits(int[] fruits, int k){
        HashMap<Integer, Integer> fruitCount = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = fruits.length;
        int maxLength = Integer.MIN_VALUE;
        while(right < n){
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            while(fruitCount.size() > k){
                int val = fruitCount.get(fruits[left]);
                val -= 1;
                if(val == 0){
                    fruitCount.remove(fruits[left]);
                }else{
                    fruitCount.put(fruits[left], val);
                }
                left += 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right += 1;
        }
        return maxLength;
    }
}
