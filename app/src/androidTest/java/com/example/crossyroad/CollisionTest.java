package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
public class CollisionTest {

    Frog f = mock(Frog.class);
    Vehicle v = mock(Vehicle.class);
    @Test
    public void testCollision() {
        Mockito.when(v.isCollided(f)).thenReturn(true);
        assertTrue(v.isCollided(f));
    }
}
