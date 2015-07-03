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
}
