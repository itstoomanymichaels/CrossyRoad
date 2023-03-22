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
public class S4LifeAfterCollision {
    private GameView gv;

    @Before
    public void setUp() {
        // Create a mock object
        gv = mock(GameView.class);
    }

    @Test
    public void testLife() {

        int life = 5;
        boolean c = true;

        //run Mockito tests
        Mockito.when(gv.getLife()).thenReturn(life);
        assertEquals(life, gv.getLife());

        Mockito.when(gv.collisionUpdate(c)).thenReturn(true);
        assertEquals(true, gv.collisionUpdate(c));

        Mockito.when(gv.getLife()).thenReturn(life - 1);
        assertEquals(true, gv.getLife() < life);
    }
}
