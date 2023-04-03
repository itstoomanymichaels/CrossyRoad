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
public class sprint4CarDecreasesLife {
    private GameView gv;

    @Before
    public void setUp() {
        // Create a mock object
        gv = mock(GameView.class);
    }

    @Test
    public void testLife() {
        int life = 3;
        boolean b = true;

        //run Mockito tests
        Mockito.when(gv.getLife()).thenReturn(life);
        assertEquals(life, gv.getLife());

        Mockito.when(gv.collisionUpdate(b)).thenReturn(true);
        assertEquals(true, gv.collisionUpdate(b));

        Mockito.when(gv.getLife()).thenReturn(life - 1);
        assertEquals(true, gv.getLife() < life);
    }
}