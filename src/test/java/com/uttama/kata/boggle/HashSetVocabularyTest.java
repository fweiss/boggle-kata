package com.uttama.kata.boggle;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class HashSetVocabularyTest {
    @Test
    public void prefixes() {
        HashSetVocabulary hashSetVocabulary = new HashSetVocabulary();
        Set<String> prefixes = hashSetVocabulary.prefixesFor(new HashSet<String>(Arrays.asList("alpha", "all", "beta")));
        assertThat(prefixes, hasSize(10));
    }
    @Test
    public void containsPrefix() {
        HashSetVocabulary hashSetVocabulary = new HashSetVocabulary();
        assertThat(hashSetVocabulary.containsPrefix("wo"), is(true));
    }
}