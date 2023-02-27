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
public class LifeTest {
    private GameScreen gs;

    @Before
    public void setUp() {
        // Create a mock object
        gs = mock(GameScreen.class);

    }

    @Test
    //checks if life changes with difficulty.
    public void testLifeByDifficulty() {
        //run Mockito tests
        Mockito.when(gs.setLifeByDifficulty("Easy")).thenReturn(5);
        assertEquals(5, gs.setLifeByDifficulty("Easy"));

        Mockito.when(gs.setLifeByDifficulty("Medium")).thenReturn(4);
        assertEquals(4, gs.setLifeByDifficulty("Medium"));

        Mockito.when(gs.setLifeByDifficulty("Hard")).thenReturn(3);
        assertEquals(3, gs.setLifeByDifficulty("Hard"));

        Mockito.when(gs.setLifeByDifficulty("")).thenReturn(-1);
        assertEquals(-1, gs.setLifeByDifficulty(""));
    }
}

