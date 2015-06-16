package com.uttama.kata.boggle;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PathTest {
    private Path emptyPath;
    @Before
    public void setup() {
        emptyPath = new Path();
    }
    @Test
    public void emptyPath() {
        assertThat(emptyPath.getLength(), is(equalTo(0)));
    }
    @Test
    public void emptyPathShouldHaveNextPathWithOneNode() {
        List<Path> paths = emptyPath.getNextPaths();
        Path nextPath = paths.get(0);
        assertThat(nextPath.getLength(), is(equalTo(1)));
    }
    @Test
    public void apply() {
        Path path = new Path(new int[]{ 1, 2, 3, 7 });
        Board board = mock(Board.class);
        when(board.asCharArray()).thenReturn(new char[]{ 'x', 'f', 'o', 'r', 'x', 'x', 'x', 'd' });
        String word = path.applyFrom(board);
        assertThat(word, is(equalTo("ford")));
    }
}
