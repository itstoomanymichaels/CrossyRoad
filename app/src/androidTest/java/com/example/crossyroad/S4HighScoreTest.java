package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(AndroidJUnit4.class)
public class S4HighScoreTest {
    private GameView gv;

    @Before
    public void setUp() {
        // Create a mock object
        gv = mock(GameView.class);
    }

    @Test
    public void testScore() {
        int score = 500;
        boolean c = true;

        //run Mockito tests
        Mockito.when(gv.getScore()).thenReturn(score);
        assertEquals(score, gv.getScore());

        Mockito.when(gv.collisionUpdate(c)).thenReturn(true);
        assertEquals(true, gv.collisionUpdate(c));

        Mockito.when(gv.getScore()).thenReturn(0);
        assertEquals(0, gv.getScore());
    }


}
