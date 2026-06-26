package org.example.greedy;

import java.util.*;

public class QueueConstruction {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        LinkedList<Pair> list = new LinkedList<>();
        for(int[] person: people){
            list.add(person[1], new Pair(person[0], person[1]));
        }

        for(int i=0; i<list.size(); i++){
            Pair curr = list.get(i);
            people[i][0] = curr.height;
            people[i][1] = curr.idx;
        }

        return people;
    }

    private static class Pair{
        int height;
        int idx;

        Pair(int height, int idx){
            this.height = height;
            this.idx = idx;
        }
    }
}
