package com.uttama.kata.boggle;

import java.util.*;

public class PathFactory {
    private static final Set<Integer> allOffsets = new HashSet<>(Arrays.asList(-5, -4, -3, -1, 1, 3, 4, 5));
    private static final Set<Integer> topExcludeOffsets = new HashSet<>(Arrays.asList(-5, -4, -3));
    private static final Set<Integer> bottomExcludeOffsets = new HashSet<>(Arrays.asList(3, 4, 5));
    private static final Set<Integer> leftExcludeOffsets = new HashSet<>(Arrays.asList(-5, -1, 3));
    private static final Set<Integer> rightExcludeOffsets = new HashSet<>(Arrays.asList(-3, 1, 5));
    private static final int numberOfRows = 4;

    public Set<Integer> getOffsetsFor(int node) {
        Set<Integer> candidate = new HashSet<>(allOffsets);
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
    public List<Path> getNextPaths(Path path) {
        int[] nodes = path.getNodes();
        int currentLength = path.getLength();
        if (currentLength == 0) {
            return getInitialPaths();
        }
        int currentNode = nodes[currentLength -1];
        List<Path> paths = new ArrayList<>();
        for (int offset : getOffsetsFor(currentNode)) {
            int candidateNode = currentNode + offset;
            if (path.containsNode(candidateNode)) {
                continue;
            }
            int[] newNodes = Arrays.copyOf(nodes, currentLength + 1);
            newNodes[currentLength] = candidateNode;
            Path newPath = new Path();
            newPath.nodes = newNodes;
            paths.add(newPath);
        }
        return paths;
    }
    public List<Path> getInitialPaths() {
        List<Path> paths = new ArrayList<>();
        for (int i=0; i<16; i++) {
            int[] nodes = new int[1];
            nodes[0] = i;
            Path newPath = new Path(nodes);
            paths.add(newPath);
        }
        return paths;
    }
}
