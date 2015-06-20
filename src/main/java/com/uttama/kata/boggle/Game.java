package com.uttama.kata.boggle;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Game {
    private final Board board;
    private final Dictionary dictionary;
    private final WordGenerator generator;
    private Set<String> words;
    public Game(Board board, Dictionary dictionary, PathOffsets pathOffsets) {
        this.board = board;
        this.dictionary = dictionary;
        generator = new WordGenerator();
        // originally, all the paths were to be generated once the board was known
        // however, the raw algorithm needs to be tempored by the words in the dictionary
//        generator.generatePaths();
    }
    public Set<String> getWords(String fill) {
        board.fillCells(fill);
        Set<String> words = generator.wordsFrom2(board, dictionary);
        return words;
    }
    public Set<String> getWords() {
        return words;
    }

    public void play() {
        words = generator.wordsFrom2(board, dictionary);
    }
}
