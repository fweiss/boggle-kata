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
    @Test(expected=IllegalArgumentException.class)
    public void fillUnderflow() {
        board.fillCells("abc");
    }
    @Test(expected=IllegalArgumentException.class)
    public void fillOverflow() {
        board.fillCells("abcdefghijklmnopqrstuvwxyz");
    }
    @Test
    public void testUpperToLowerCase() {
        board.fillCells("ABCDEFGHIJKLMNOP");
        char[] cells = board.asCharArray();
        assertThat(cells[1], is(equalTo('b')));
    }
    @Test
    public void create() {
        assertThat(board.getWidth(), is(equalTo(4)));
        assertThat(board.getHeight(), is(equalTo(4)));
    }
    @Test
    public void asCharArray() {
        board.fillCells("xyzabczzzzzzzzzz");
        char[] cells = board.asCharArray();
        assertThat(cells, is(new char[]{ 'x', 'y', 'z', 'a', 'b', 'c', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z' }));
    }
    @Test
    public void applyZero() {
        Path path = new Path();
        String word = board.apply(path);
        assertThat(word, is(equalTo("")));
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
