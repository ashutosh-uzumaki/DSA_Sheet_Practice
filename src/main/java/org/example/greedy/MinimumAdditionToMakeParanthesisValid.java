package org.example.greedy;

import java.util.*;

public class MinimumAdditionToMakeParanthesisValid {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                open++;
            }else if(open > 0){
                open--;
            }else{
                close++;
            }
        }

        return open + close;
    }
}
