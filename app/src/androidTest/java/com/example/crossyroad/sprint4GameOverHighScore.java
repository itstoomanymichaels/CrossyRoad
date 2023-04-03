package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import android.widget.TextView;

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
public class sprint4GameOverHighScore {
    private GameOver go;

    @Before
    public void setUp() {
        // Create a mock object
        go = mock(GameOver.class);
    }

    @Test
    public void testHighScore() {
        TextView score = null;
        //run Mockito tests
        Mockito.when(go.getScore()).thenReturn(score);
        assertEquals(score, go.getScore());
    }
}

