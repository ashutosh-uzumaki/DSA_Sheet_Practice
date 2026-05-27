package org.example.recursion.basic;

public class StringToInteger {
    public int myAtoi(String s) {
        int sign = 1;
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }

        if(i < s.length() && s.charAt(i) == '+'){
            i++;
        }else if(i < s.length() && s.charAt(i) == '-'){
            i++;
            sign = -1;
        }

        return helper(0l, i, s, sign);
    }

    private int helper(long num, int i, String s, int sign){
        if(i == s.length()){
            return (int)(sign * num);
        }

        if(!Character.isDigit(s.charAt(i))){
            return (int)(sign * num);
        }

        num = num * 10 + s.charAt(i) - '0';

        if(num * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(num * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)helper(num, i + 1, s, sign);
    }
}
