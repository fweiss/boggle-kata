package com.uttama.kata.boggle;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class WordGeneratorTest {

    private Board board;
    private WordGenerator generator;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        generator = new WordGenerator();
    }

    @Test @Ignore
    public void listOfWords() {
        List<String> words = generator.wordsFrom(board);
        assertThat(words.size(), is(equalTo(0)));
    }
    @Test
    public void generate() {
        board.fillCells("wordplacefouryard");
        List<String> words = generator.wordsFrom(board);
        assertThat(words.size(), is(greaterThan(4)));
    }

}