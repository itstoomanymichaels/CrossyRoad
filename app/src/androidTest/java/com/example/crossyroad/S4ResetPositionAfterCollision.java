package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import android.content.res.Resources;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(AndroidJUnit4.class)
public class S4ResetPositionAfterCollision {
    private GameView gv;
    private Frog frog;

    private Frog startingFrog;

    @Before
    public void setUp() {
        // Create a mock object
        gv = mock(GameView.class);
        startingFrog = mock(Frog.class);
    }

    @Test
    public void testPosition() {
        //sample screen size
        int screenX = 200;
        int screenY = 200;

        //acting as tracking frog coordinates
        int x = 0;
        int y = 0;

        frog = new Frog(screenY, screenX, Resources.getSystem(), 1);

        //starting coordinates/coordinates after collision
        int resetX = (screenX / 2) - (frog.getWidth() / 2);
        int resetY = screenY - frog.getHeight() - 15;

        //for collision
        boolean c = true;

        Mockito.when(startingFrog.getX()).thenReturn(resetX);
        Mockito.when(startingFrog.getY()).thenReturn(resetY);

        frog.moveUp();
        y = frog.getY();
        frog.moveLeft();
        x = frog.getX();

        //testing if frog has moved
        assertTrue(y < startingFrog.getY());
        assertTrue(x < startingFrog.getX());

        //collision being true
        Mockito.when(gv.collisionUpdate(c)).thenReturn(true);
        assertEquals(true, gv.collisionUpdate(c));

        //ACTUAL TEST
        //once collision occurs
        if (c) {
            y = resetY;
            x = resetX;
        }

        assertEquals(startingFrog.getX(), x);
        assertEquals(startingFrog.getY(), y);
    }
}
