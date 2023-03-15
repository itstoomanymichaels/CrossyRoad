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
public class ScoreIncreaseTest {
    private GameView gv;
    private Frog frog;

    @Before
    public void setUp() {
        // Create a mock object
        gv = mock(GameView.class);
        frog = mock(Frog.class);
    }

    @Test
    public void testScore() {

        int y = 450;
        int screenY = 720;
        int score = 0;

        //run Mockito tests
        Mockito.when(frog.moveUp()).thenReturn(y - (2 * screenY / 36));
        assertEquals(410, frog.moveUp());

        Mockito.when(gv.getScore()).thenReturn(score + 500);
        assertEquals(500, gv.getScore());
    }
}
