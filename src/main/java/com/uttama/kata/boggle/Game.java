package com.uttama.kata.boggle;

import java.util.Set;

public class Game {
    private final Board board;
    private final Vocabulary vocabulary;
    private final WordGenerator generator;
    private Set<String> words;

    /**
     * A Game is composed of a board, path factory, and a vocabulary.
     * A board provides a geometry and a matrix of cells. Each cell contains a letter.
     * @param board
     * @param vocabulary
     * @param pathFactory
     */
    public Game(Board board, Vocabulary vocabulary, PathFactory pathFactory) {
        this.board = board;
        this.vocabulary = vocabulary;
        generator = new WordGenerator();
        // originally, all the paths were to be generated once the board was known
        // however, the raw algorithm needs to be tempered by the words in the dictionary
//        generator.generatePaths();
    }
    public Set<String> getWords(String fill) {
        board.fillCells(fill);
        Set<String> words = generator.wordsFrom2(board, vocabulary);
        return words;
    }
    public Set<String> getWords() {
        return words;
    }

    public void play() {
        words = generator.wordsFrom2(board, vocabulary);
    }
}
