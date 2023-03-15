package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import android.graphics.Point;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class Sprint3DifferentSprite {
    private GameScreen gs;
    private Point point = new Point();
    private Road rd;
    private Vehicle[] vehicles;

    @Before
    public void setUp() {
        // Create a mock object
        gs = mock(GameScreen.class);
        point = gs.getPoint();
        rd = new Road(point.x, point.y, gs.getResources());
        Vehicle[] vehicles = rd.getVehicles();
    }

    @Test
    public void sameSprite() {
        //checks if sprite selected in configScreen same as sprite shown in gameScreen
        assertEquals(true, vehicles[0].getClass() == vehicles[4].getClass());
        assertEquals(false, vehicles[7].getClass() == vehicles[4].getClass());
        assertEquals(true, vehicles[10].getClass() == vehicles[7].getClass());
        assertEquals(false, vehicles[14].getClass() == vehicles[10].getClass());
        assertEquals(true, vehicles[16].getClass() == vehicles[14].getClass());
    }
}
