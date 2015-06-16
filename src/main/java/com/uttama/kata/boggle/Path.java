package com.uttama.kata.boggle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

/**
 * A Path visits a subset of the positions on a board.
 */
public class Path {
    private int[] nodes;

    public Path() {
        nodes = new int[0];
    }

    protected Path(int[] nodes) {
        this.nodes = Arrays.copyOf(nodes, nodes.length);
    }

    public int getLength() {
        return nodes.length;
    }

    public List<Path> getNextPaths() {
        int currentLength = nodes.length;
        if (currentLength == 0) {
            return empty();
        }
        int currentNode = nodes[currentLength -1];
        List<Path> paths = new ArrayList<Path>();
        PathOffsets pathOffsets = new PathOffsets();
        for (int offset : pathOffsets.forNode(currentNode)) {
            int candidateNode = currentNode + offset;
            if (containsNode(candidateNode)) {
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
    private List<Path> empty() {
        List<Path> paths = new ArrayList<Path>();
        int currentLength = nodes.length;
        for (int i=0; i<16; i++) {
            int[] newNodes = Arrays.copyOf(nodes, currentLength + 1);
            newNodes[currentLength] = i;
            Path newPath = new Path();
            newPath.nodes = newNodes;
            paths.add(newPath);
        }
        return paths;
    }

    public String applyFrom(Board board) {
        char[] cells = board.asCharArray();
        StringBuffer word = new StringBuffer();
        for (int i=0; i<nodes.length; i++) {
            word.append(cells[nodes[i]]);
        }
        return word.toString();
    }
    private boolean containsNode(int node) {
        for (int i=0; i<nodes.length; i++) {
            if (nodes[i] == node) {
                return true;
            }
        }
        return false;
    }
}
