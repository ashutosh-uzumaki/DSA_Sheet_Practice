package org.example.dynamic_programming.russian_doll_envelopes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RussianDollEnvelopesBinarySearch {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        List<Integer> tails = new ArrayList<>();

        for (int[] envelope : envelopes) {
            int height = envelope[1];

            int pos = Collections.binarySearch(tails, height);
            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos == tails.size()) {
                tails.add(height);
            } else {
                tails.set(pos, height);
            }
        }

        return tails.size();
    }
}
