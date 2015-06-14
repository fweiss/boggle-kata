package com.uttama.kata.boggle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class WordGenerator {
    List<Path> paths;
    public WordGenerator() {
        paths = new ArrayList<Path>();
        Deque<Path> visit = new ArrayDeque<Path>();
        visit.push(new Path());
        while ( ! visit.isEmpty()) {
            Path visitedPath = visit.pop();
            paths.add(visitedPath);
            List<Path> nextPaths = visitedPath.getNextPaths();
            visit.addAll(nextPaths);
        }
    }
    public List<String> wordsFrom(Board board) {
        List<String> words = new ArrayList<String>();
        for (Path path : paths) {
            words.add(path.applyFrom(board));
        }
        return words;
    }
}
