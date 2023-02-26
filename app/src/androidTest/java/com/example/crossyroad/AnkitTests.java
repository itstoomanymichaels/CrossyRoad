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
public class AnkitTests {
    private GameScreen gs;

    @Before
    public void setUp() {
        // Create a mock object
        gs = mock(GameScreen.class);
    }

    @Test
    public void testLifeByDifficulty() {

        //run Mockito tests
        Mockito.when(gs.SetLifeByDifficulty("Easy")).thenReturn(5);
        assertEquals(5, gs.SetLifeByDifficulty("Easy"));

        Mockito.when(gs.SetLifeByDifficulty("Medium")).thenReturn(4);
        assertEquals(4, gs.SetLifeByDifficulty("Medium"));

        Mockito.when(gs.SetLifeByDifficulty("Hard")).thenReturn(3);
        assertEquals(3, gs.SetLifeByDifficulty("Hard"));

        Mockito.when(gs.SetLifeByDifficulty("")).thenReturn(-1);
        assertEquals(-1, gs.SetLifeByDifficulty(""));

    }
}
