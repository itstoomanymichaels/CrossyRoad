package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestBounds {
    private GameScreen gs;

    @Before
    public void setUp() {
        // Create a mock object
        gs = mock(GameScreen.class);
    }

    @Test
    public void testBounds() {
        int exampleHeight = 100;
        int exampleWidth = 100;
        //run Mockito tests
        Mockito.when(gs.testBounds(exampleWidth, exampleHeight)).thenReturn(true);
        assertEquals(true, gs.testBounds(exampleWidth, exampleHeight));

        Mockito.when(gs.testBounds(0, 0)).thenReturn(false);
        assertEquals(false, gs.testBounds(0, 0));

    }
}
