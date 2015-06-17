package com.uttama.kata.boggle;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class BoardTest {
    Board board;
    @Before
    public void setup() {
        board = new Board();
        board.fillCells("abcd" + "efgh" + "ijkl" + "mnop");
    }
    @Test
    public void create() {
        assertThat(board.getWidth(), is(equalTo(4)));
        assertThat(board.getHeight(), is(equalTo(4)));
    }
    @Test
    public void asCharArray() {
        board.fillCells("xyzabc");
        char[] cells = board.asCharArray();
        assertThat(cells, is(new char[]{ 'x', 'y', 'z', 'a', 'b', 'c' }));
    }
    @Test
    public void applyZero() {
        Path path = new Path();
        String word = board.apply(path);
        assertThat(word, is(equalTo("")));
    }
    @Test
    public void applyOne() {
        Path path = new Path();
        List<Path> paths = path.getNextPaths();
        String word = board.apply(paths.get(0));
        assertThat(word, is(equalTo("a")));
    }
    @Test
    public void applyTwo() {
        Path mockPath = mock(Path.class);
        when(mockPath.getNodes()).thenReturn(new int[]{ 5, 2});
        String word = board.apply(mockPath);
        assertThat(word, is("fc"));
    }
    @Test
    public void fill() {
        assertThat(board.getCell(0, 0), is(equalTo('a')));
        assertThat(board.getCell(3,3), is(equalTo('p')));

    }
}
