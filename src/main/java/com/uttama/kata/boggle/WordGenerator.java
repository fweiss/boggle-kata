package com.uttama.kata.boggle;

import java.util.*;

public class WordGenerator {
    private final PathFactory pathFactory;
    List<Path> paths;
    public WordGenerator() {
        pathFactory = new PathFactory();
    }
    // this does the brute force 12M
    public void generatePaths() {
        paths = new ArrayList<Path>();
        Deque<Path> visit = new ArrayDeque<Path>();
        visit.push(new Path());
        while ( ! visit.isEmpty()) {
            Path visitedPath = visit.pop();
            paths.add(visitedPath);
            List<Path> nextPaths = pathFactory.getNextPaths(visitedPath);
//            List<Path> nextPaths = visitedPath.getNextPaths();
            visit.addAll(nextPaths);
        }
    }

    public List<String> wordsFrom(Board board) {
        List<String> words = new ArrayList<String>();
        for (Path path : paths) {
//            words.add(path.applyFrom(board));
            String word = board.apply(path);
            words.add(word);
        }
        return words;
    }
    public Set<String> wordsFrom2(Board board, Vocabulary vocabulary) {
        Set<String> words = new HashSet<String>();
        paths = new ArrayList<Path>();
        Deque<Path> visit = new ArrayDeque<Path>();
        visit.push(new Path());
        while ( ! visit.isEmpty()) {
            Path visitedPath = visit.pop();
            paths.add(visitedPath);
            String visitedWord = board.apply(visitedPath);
            if (vocabulary.contains(visitedWord)) {
                words.add(visitedWord);
            }
            List<Path> nextPaths = pathFactory.getNextPaths(visitedPath);
            for (Path path : nextPaths) {
                String word = board.apply(path);
                if (vocabulary.containsPrefix(word)) {
                    visit.add(path);
                }
            }
        }
        return words;
    }

    protected Set<String> applyPathsToBoard(List<Path> paths, Board board, Vocabulary vocabulary) {
        Set<String> words = new HashSet<>();
        for (Path path : paths) {
            String word = board.apply(path);
            if (vocabulary.contains(word)) {
                words.add(word);
            }
        }
        return words;
    }
}
