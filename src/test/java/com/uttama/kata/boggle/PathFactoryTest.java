package com.uttama.kata.boggle;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

public class PathFactoryTest {

    private PathFactory pathFactory;

    @Before
    public void setUp() throws Exception {
        pathFactory = new PathFactory();
    }
    @Test
    public void numberOfInitialPaths() {
        List<Path> initialPaths = pathFactory.getInitialPaths();
        assertThat(initialPaths.size(), is(16));
    }
    @Test
    public void initialPathHasNode() {
        List<Path> initialPaths = pathFactory.getInitialPaths();
        Path path = initialPaths.get(12);
        assertThat(path.getLength(), is(1));
        assertThat(path.containsNode(12), is(true));
    }
    @Test
    public void emptyPathShouldHaveNextPathWithOneNode() {
        Path emptyPath = new Path();
        List<Path> nextPaths = pathFactory.getNextPaths(emptyPath);
        Path nextPath = nextPaths.get(0);
        assertThat(nextPath.getLength(), is(equalTo(1)));
    }
    @Test
    public void getCenterMiddle() {
        Set<Integer> offsets = pathFactory.forNode(5);
        assertThat(offsets, hasSize(8));
        assertThat(offsets, containsInAnyOrder(-5, -4, -3, -1, 1, 3, 4, 5));
    }
    @Test
    public void topLeft() {
        Set<Integer> offsets = pathFactory.forNode(0);
        assertThat(offsets, hasSize(3));
        assertThat(offsets, containsInAnyOrder(1, 4, 5));
    }
    @Test
    public void bottomRight() {
        Set<Integer> offsets = pathFactory.forNode(15);
        assertThat(offsets, hasSize(3));
        assertThat(offsets, containsInAnyOrder(-5, -4, -1));
    }
    @Test
    public void middleRight() {
        Set<Integer> offsets = pathFactory.forNode(7);
        assertThat(offsets, hasSize(5));
        assertThat(offsets, containsInAnyOrder(-5, -4, -1, 3, 4));
    }

}