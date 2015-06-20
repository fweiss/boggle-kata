package com.uttama.kata.boggle;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class GameTest {

    private Board board;
    private Dictionary dictionary;
    private Game game;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        dictionary = new Dictionary();
        dictionary.loadPrefixes(); // move
        game = new Game(board, dictionary, null);
    }

    @Test
    public void simpleOneWord() {
//        PathOffsets pathOffsets = new PathOffsets();
        Set<String> words = game.getWords("andzzzzzzzzzzzzz");
        assertThat(words.size(), is(equalTo(1)));
    }
    @Test
    public void aGame() {
        board.fillCells("ANTD" + "FIRT" + "SOWE" + "PAST");
        game.play();
        Set<String> words = game.getWords();
        assertThat(words, containsInAnyOrder("ant"));
    }

}