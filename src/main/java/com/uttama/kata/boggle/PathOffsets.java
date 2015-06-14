package com.uttama.kata.boggle;

import java.util.*;

public class PathOffsets {
    private static final Set<Integer> allOffsets = new HashSet(Arrays.asList(-5, -4, -3, -1, 1, 3, 4, 5));
    private static final Set<Integer> topExcludeOffsets = new HashSet(Arrays.asList(-5, -4, -3));
    private static final Set<Integer> bottomExcludeOffsets = new HashSet(Arrays.asList(3, 4, 5));
    private static final Set<Integer> leftExcludeOffsets = new HashSet(Arrays.asList(-5, -1, 3));
    private static final Set<Integer> rightExcludeOffsets = new HashSet(Arrays.asList(-3, 1, 5));
    private static final int numberOfRows = 4;

    public Set<Integer> forNode(int node) {
        Set<Integer> candidate = new HashSet<Integer>(allOffsets);
        int row = node / numberOfRows;
        int col = node % numberOfRows;
        if (row == 0) {
            candidate.removeAll(topExcludeOffsets);
        }
        if (row == 3) {
            candidate.removeAll(bottomExcludeOffsets);
        }
        if (col == 0) {
            candidate.removeAll(leftExcludeOffsets);
        }
        if (col == 3) {
            candidate.removeAll(rightExcludeOffsets);
        }
        return candidate;
    }
}
