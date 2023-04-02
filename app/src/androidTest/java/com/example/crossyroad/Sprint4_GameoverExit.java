package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import android.content.Context;
import android.widget.Button;

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
public class Sprint4_GameoverExit {
    private GameOver go;
    @Before
    public void setUp() {
        // Create a mock object
        go = mock(GameOver.class);
    }

    @Test
    public void testExit() {
        Button quit = null;
        //run Mockito tests
        Mockito.when(go.getQuit()).thenReturn(quit);
        assertEquals(quit, go.getQuit());
    }
}
