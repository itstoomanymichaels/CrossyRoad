package com.example.crossyroad;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import android.graphics.Canvas;

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
public class ScreenChangeTest {
    private GameView gv;
    private Canvas c;


    @Before
    public void setUp() {
        // Create a mock object
        gv = mock(GameView.class);
        c = mock(Canvas.class);
    }

    @Test
    public void testScore() {


        Mockito.when(gv.isGameOver()).thenReturn(true);
        Mockito.when(gv.getLife()).thenReturn(0);
        if (gv.getLife() == 0) {
            assertTrue(gv.isGameOver());
        }
    }
}

