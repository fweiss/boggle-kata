package com.uttama.kata.boggle;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FourByFourPathTest {
    private PathFactory pathFactory;
    @Before
    public void before() {
        pathFactory = new PathFactory();
    }
    @Test
    public void fromEmpty() {
        Path emptyPath = new Path();
        List<Path> nextPaths = pathFactory.getNextPaths(emptyPath);
        assertThat(nextPaths.size(), is(equalTo(16)));
    }
    @Test
    public void fromCorner() {
        Path pathWithOne = new Path(new int[]{ 0 });
        List<Path> nextPaths = pathFactory.getNextPaths(pathWithOne);
        assertThat(nextPaths.size(), is(equalTo(3)));
    }
    @Test
    public void fromOneNodesIncreased() {
        Path pathWithOne = new Path(new int[]{ 1 });
        List<Path> nextPaths = pathFactory.getNextPaths(pathWithOne);
        Path firstPath = nextPaths.get(0);
        assertThat(firstPath.getLength(), is(equalTo(2)));
    }
    @Test
    public void fromTwoNodes() {
        Path pathWithOne = new Path(new int[]{ 1, 2 });
        List<Path> nextPaths = pathFactory.getNextPaths(pathWithOne);
        assertThat(nextPaths.size(), is(equalTo(4)));
    }
    @Test
    public void fromFull() {
        Path fullPath = new Path(new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
        List<Path> nextPaths = pathFactory.getNextPaths(fullPath);
        assertThat(nextPaths.size(), is(equalTo(0)));
    }
}
