package com.uttama.kata.boggle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetVocabulary implements Vocabulary {
    private final Set<String> words;
    private final Set<String> prefixes;

    public HashSetVocabulary() {
        words = defaultWords;
        prefixes = prefixesFor(words);
    }
    public HashSetVocabulary(String[] words) {
        this.words = new HashSet<String>(Arrays.asList(words));
        prefixes = prefixesFor(this.words);
    }
    @Override
    public boolean contains(String word) {
        return words.contains(word);
    }
    @Override
    public boolean containsPrefix(String prefix) {
        return prefixes.contains(prefix);
    }
    private static final Set<String> defaultWords = new HashSet<String>(Arrays.asList(
            "and",
            "ant",
            "antelope",
            "ape",
            "apex",
            "apple",
            "axe",
            "be",
            "beard",
            "beat",
            "bell",
            "best",
            "bestow",
            "call",
            "cap",
            "car",
            "card",
            "do",
            "dog",
            "doll",
            "egg",
            "elephant",
            "fee",
            "feed",
            "foot",
            "fuss",
            "gin",
            "go",
            "goal",
            "gone",
            "he",
            "his",
            "hole",
            "hood",
            "in",
            "ink",
            "isle",
            "jail",
            "jar",
            "justice",
            "kettle",
            "kind",
            "kit",
            "log",
            "love",
            "me",
            "men",
            "meat",
            "measure",
            "measurement",
            "nick",
            "nod",
            "noodle",
            "next",
            "oil",
            "old",
            "one",
            "pat",
            "pet",
            "pest",
            "pot",
            "post",
            "postpone",
            "quail",
            "quick",
            "quip",
            "red",
            "rise",
            "rod",
            "rope",
            "roster",
            "sag",
            "saint",
            "seed",
            "shale",
            "soul",
            "tell",
            "tone",
            "torn",
            "tupple",
            "umbrella",
            "under",
            "vet",
            "vent",
            "vice",
            "we",
            "won",
            "word",
            "worn",
            "xylophone",
            "zebra",
            "zen",
            "zest",
            "zoo"
            ));

    public Set<String> prefixesFor(Set<String> words) {
        Set<String> prefixes = new HashSet<>();
        for (String word : words) {
            for (int i=1; i<word.length()+1; i++) {
                String prefix = word.substring(0, i);
                prefixes.add(prefix);
            }
        }
        return prefixes;
    }
}
