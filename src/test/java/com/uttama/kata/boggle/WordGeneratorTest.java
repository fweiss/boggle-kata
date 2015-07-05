package com.uttama.kata.boggle;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WordGeneratorTest {

    private Board board;
    private WordGenerator generator;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        generator = new WordGenerator();
    }

    @Test
    public void listOfWords() {
//        board.fillCells("wordplacefouryard");
        board.fillCells("wordxxxxxxxxxxxx");
        HashSetVocabulary vocabulary = new HashSetVocabulary();
        Set<String> words = generator.wordsFrom(board, vocabulary);
        assertThat(words.size(), is(equalTo(1)));
    }
    // this one takes 15 sec
    @Test @Ignore
    public void generateAllPossible() {
        board.fillCells("wordplacefouryard");
        generator.generatePaths();
    }
    @Test
    public void applyPathsToBoard() {
        board.fillCells("xone" + "twox" + "tree" + "hxxx");
        List<Path> paths = new ArrayList<>();
        paths.add(new Path(new int[]{ 1, 2, 3 }));
        paths.add(new Path(new int[]{ 4, 5, 6 }));
        paths.add(new Path(new int[]{ 8, 12, 9, 10, 11 }));
        Vocabulary vocabulary = new HashSetVocabulary(new String[] { "one", "two", "three" });
        Set<String> words = generator.wordsFrom(board, vocabulary);
        assertThat(words, hasSize(3));
        assertThat(words, containsInAnyOrder("one", "two", "three"));
    }

}