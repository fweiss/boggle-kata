package com.uttama.kata.boggle;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Game {
    private final Board board;
    private final Dictionary dictionary;
    private final WordGenerator generator;
    public Game(Board board, Dictionary dictionary, PathOffsets pathOffsets) {
        this.board = board;
        this.dictionary = dictionary;
        generator = new WordGenerator();
        generator.generatePaths();
    }
    public Set<String> getWords(String fill) {
        board.fillCells(fill);
        Set<String> words = generator.wordsFrom2(board, dictionary);
        return words;
    }
}
