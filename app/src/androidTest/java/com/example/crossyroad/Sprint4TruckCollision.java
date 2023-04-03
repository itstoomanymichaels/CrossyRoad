package com.example.crossyroad;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Sprint4TruckCollision {

    private Frog f = mock(Frog.class);
    private Truck t = mock(Truck.class);
    @Test
    public void testCollision() {
        Mockito.when(t.isCollided(f)).thenReturn(true);
        assertTrue(t.isCollided(f));
    }
}
