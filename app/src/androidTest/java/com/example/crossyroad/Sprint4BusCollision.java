package com.example.crossyroad;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import android.content.res.Resources;

import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.mockito.Mockito;


@RunWith(AndroidJUnit4.class)
public class Sprint4BusCollision {

    private Vehicle v = new Car(50, 82, 200, 100, 10, "L",
            Resources.getSystem());
    private Frog f = new Frog(0, 0, Resources.getSystem(), 0);

    @Before
    public void setup() {
        v = mock(Bus.class);
        f = mock(Frog.class);
    }

    @Test
    public void busCollides() {
        int x = v.getX();
        f.setSize(100, 100);
        Mockito.when(v.isCollided(f)).thenReturn(true);
        assertEquals(v.isCollided(f), true);

    }
}
