package com.uttama.kata.boggle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A Path visits a subset of the positions on a board.
 */
public class Path {
    protected int[] nodes;

    public Path() {
        nodes = new int[0];
    }

    protected Path(int[] nodes) {
        this.nodes = Arrays.copyOf(nodes, nodes.length);
    }

    public int getLength() {
        return nodes.length;
    }

    public int[] getNodes() {
        return nodes;
    }

    protected List<Path> xempty() {
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

    protected boolean containsNode(int node) {
        for (int i=0; i<nodes.length; i++) {
            if (nodes[i] == node) {
                return true;
            }
        }
        return false;
    }
}
