package org.example.graphs.dfs;

import java.util.*;

public class PathCheck {
    private int source;
    private int destination;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.source = source;
        this.destination = destination;
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }

        boolean[] visited = new boolean[n];
        return pathExists(source, visited, adj, n);
    }

    private boolean pathExists(int node, boolean[] visited, List<Integer>[] adj, int n){
        if(node == destination){
            return true;
        }

        visited[node] = true;

        for(int nbr: adj[node]){
            if(!visited[nbr]){
                if(pathExists(nbr, visited, adj, n)){
                    return true;
                }
            }
        }

        return false;
    }
}
