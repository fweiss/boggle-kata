package com.uttama.kata.boggle;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class GameTest {

    private Board board;
    private Vocabulary vocabulary;
    private Game game;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        vocabulary = new HashSetVocabulary();
        game = new Game(board, vocabulary, null);
    }

    @Test
    public void simpleOneWord() {
        Set<String> words = game.getWords("andzzzzzzzzzzzzz");
        assertThat(words.size(), is(equalTo(1)));
    }
    @Test
    public void example1() {
        board.fillCells("ANTD" + "FIRT" + "SOWE" + "PAST");
        game.play();
        Set<String> words = game.getWords();
        assertThat(words, hasItems("ant"));
    }

}