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

    protected boolean containsNode(int node) {
        for (int i=0; i<nodes.length; i++) {
            if (nodes[i] == node) {
                return true;
            }
        }
        return false;
    }
}
