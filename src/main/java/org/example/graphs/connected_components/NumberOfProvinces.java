package org.example.graphs.connected_components;

import java.util.*;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int provinces = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                provinces+=1;
                dfs(i, visited, adj);
            }
        }
        return provinces;
    }

    private void dfs(int src, boolean[] visited, List<List<Integer>> adj){
        if(visited[src]){
            return;
        }

        visited[src] = true;
        for(Integer nbr: adj.get(src)){
            if(!visited[nbr]){
                dfs(nbr, visited, adj);
            }
        }
    }
}
