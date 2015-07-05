package com.uttama.kata.boggle;

/**
 * The Vocabulary interface defines the capability to query if a given word is valid.
 * It also provides the capability to verify is a given string is a prefix of a valid
 * word. This is used to optimize the search algorithm.
 */
public interface Vocabulary {

    boolean contains(String word);

    boolean containsPrefix(String prefix);
}
