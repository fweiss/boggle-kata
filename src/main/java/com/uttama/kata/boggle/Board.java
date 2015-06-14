package com.uttama.kata.boggle;

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

    public void setCell(int x, int y, char letter) {

    }

    public String apply(Path path) {
        return path.getLength() == 0 ? "" : "a";
    }

    public void fillCells(String wordplacefouryard) {
        cells = wordplacefouryard.toCharArray();
    }

    public char[] asCharArray() {
        return new char[0];
    }
}
