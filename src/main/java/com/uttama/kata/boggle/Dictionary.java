package com.uttama.kata.boggle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    public boolean contains(String word) {
        return words.contains(word);
    }
    private static final Set<String> words = new HashSet(Arrays.asList(
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
