package com.uttama.kata.boggle;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void test() {
        Board board = new Board();
        Dictionary dictionary = new Dictionary();
        dictionary.loadPrefixes(); // move
        PathOffsets pathOffsets = new PathOffsets();
        Game game = new Game(board, dictionary, pathOffsets);
        Set<String> words = game.getWords("andzzzzzzzzzzzzz");
        assertThat(words.size(), is(equalTo(1)));
    }
    @Test @Ignore
    public void aGame() {
        Board board = new Board();
        board.fillCells(
"A"+
"N"+
"T"+
"D"+
"F"+
"I"+
"R"+
"T"+
"S"+
"O"+
"WE"+
"P"+
"A"+
"S"+
"T"
        );
        Set<String> words = board.getWords();
        assertThat(words, contains("ant"));
    }

}