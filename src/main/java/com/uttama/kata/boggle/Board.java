package com.uttama.kata.boggle;

/**
 * A board has rows and columns of cells and each cell contains a letter.
 * A path can be applied to a board.
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

    public void fillCells(String fillString) {
        if (fillString.length() != getWidth() * getHeight()) {
            throw new IllegalArgumentException("expected 16 characters");
        }
        cells = fillString.toLowerCase().toCharArray();
    }

    public char[] asCharArray() {
        return cells;
    }
}
