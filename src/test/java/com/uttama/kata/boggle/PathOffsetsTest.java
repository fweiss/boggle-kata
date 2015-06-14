package com.uttama.kata.boggle;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class PathOffsetsTest {

    private PathOffsets pathOffsets;

    @Before
    public void setUp() throws Exception {
        pathOffsets = new PathOffsets();
    }

    @Test
    public void getCenterMiddle() {
        Set<Integer> offsets = pathOffsets.forNode(5);
        assertThat(offsets, hasSize(8));
        assertThat(offsets, containsInAnyOrder(-5, -4, -3, -1, 1, 3, 4, 5));
    }
    @Test
    public void topLeft() {
        Set<Integer> offsets = pathOffsets.forNode(0);
        assertThat(offsets, hasSize(3));
        assertThat(offsets, containsInAnyOrder(1, 4, 5));
    }
    @Test
    public void bottomRight() {
        Set<Integer> offsets = pathOffsets.forNode(15);
        assertThat(offsets, hasSize(3));
        assertThat(offsets, containsInAnyOrder(-5, -4, -1));
    }
    @Test
    public void middleRight() {
        Set<Integer> offsets = pathOffsets.forNode(7);
        assertThat(offsets, hasSize(5));
        assertThat(offsets, containsInAnyOrder(-5, -4, -1, 3, 4));
    }

}