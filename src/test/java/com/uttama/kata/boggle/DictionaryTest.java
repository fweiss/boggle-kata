package com.uttama.kata.boggle;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class DictionaryTest {
    @Test
    public void prefixes() {
        Dictionary dictionary = new Dictionary();
        Set<String> prefixes = dictionary.prefixesFor(new HashSet<String>(Arrays.asList("alpha", "all", "beta")));
        assertThat(prefixes, hasSize(10));
    }

}