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
public class ForwardTest {
    private GameScreen gs;

    @Before
    public void setUp() {
        // Create a mock object
        gs = mock(GameScreen.class);
    }

    @Test
    public void testNames() {

        int y = 0;

        int oneMove = 50;

        //run Mockito tests
        Mockito.when(gs.upPos(y)).thenReturn(y + oneMove);
        assertEquals(50, gs.upPos(y));
    }
}