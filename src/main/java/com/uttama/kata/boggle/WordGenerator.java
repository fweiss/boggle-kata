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
        paths = new ArrayList<>();
        Deque<Path> visit = new ArrayDeque<>();
        visit.push(new Path());
        while ( ! visit.isEmpty()) {
            Path visitedPath = visit.pop();
            paths.add(visitedPath);
            List<Path> nextPaths = pathFactory.getNextPaths(visitedPath);
            visit.addAll(nextPaths);
        }
    }

    public Set<String> wordsFrom(Board board, Vocabulary vocabulary) {
        Set<String> words = new HashSet<>();
        paths = new ArrayList<>();
        Deque<Path> visit = new ArrayDeque<>();
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
}
