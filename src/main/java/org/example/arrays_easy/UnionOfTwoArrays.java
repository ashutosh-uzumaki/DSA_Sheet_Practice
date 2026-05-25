package org.example.arrays_easy;

import java.util.*;

public class UnionOfTwoArrays {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != a[i])
                    union.add(a[i]);
                i++;
            } else if (b[j] < a[i]) {
                if (union.isEmpty() || union.get(union.size() - 1) != b[j])
                    union.add(b[j]);
                j++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != a[i])
                    union.add(a[i]);
                i++;
                j++;
            }
        }

        while (i < a.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != a[i])
                union.add(a[i]);
            i++;
        }

        while (j < b.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != b[j])
                union.add(b[j]);
            j++;
        }

        return union;
    }
}
