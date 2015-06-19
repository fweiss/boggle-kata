package com.uttama.kata.boggle;

import java.util.Set;

/**
 * Created by frankw on 6/12/2015.
 */
public class Board {
    private char[] cells;
    public Board() {
    }

    public int getWidth() {
        return 4;
    }

    public int getHeight() {
        return 4;
    }

    public char getCell(int x, int y) {
        return cells[x + y * 4];
    }

    public String apply(Path path) {
        int[] nodes = path.getNodes();
        StringBuffer word = new StringBuffer();
        for (int i=0; i<nodes.length; i++) {
            word.append(cells[nodes[i]]);
        }
        return word.toString();
    }

    public void fillCells(String wordplacefouryard) {
        if (wordplacefouryard.length() < getWidth() * getHeight()) {
            throw new IllegalArgumentException("expected 16 characters");
        }
        cells = wordplacefouryard.toCharArray();
    }

    public char[] asCharArray() {
        return cells;
    }

    public Set<String> getWords() {
        return null;
    }
}
