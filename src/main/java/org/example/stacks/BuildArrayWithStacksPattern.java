package org.example.stacks;

import java.util.*;

public class BuildArrayWithStacksPattern {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int idx = 0;
        for(int i=1; i<=n; i++){
            if(idx < target.length && i == target[idx]){
                ans.add("Push");
                idx += 1;
            }else if(idx < target.length){
                ans.add("Push");
                ans.add("Pop");
            }
        }

        return ans;
    }
}
