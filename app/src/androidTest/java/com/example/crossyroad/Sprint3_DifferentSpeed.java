package com.example.crossyroad;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import android.graphics.Point;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.content.res.Resources;

@RunWith(AndroidJUnit4.class)
public class Sprint3_DifferentSpeed{
    private GameScreen gs;
    Point point = new Point();
    Road rd;
    Vehicle[] vehicles;

    @Before
    public void setUp(){
        // Create a mock object
        gs=mock(GameScreen.class);
        point = gs.getPoint();
        rd = new Road(point.x, point.y, gs.getResources());
        Vehicle[] vehicles = rd.getVehicles();
    }

    @Test
    public void sameSprite(){
        //checks if sprite selected in configScreen same as sprite shown in gameScreen
        assertEquals(true, vehicles[0].getSpeed() == vehicles[4].getSpeed());
        assertEquals(false, vehicles[7].getSpeed() == vehicles[4].getSpeed());
        assertEquals(true, vehicles[10].getSpeed() == vehicles[7].getSpeed());
        assertEquals(false, vehicles[14].getSpeed() == vehicles[10].getSpeed());
        assertEquals(true, vehicles[16].getSpeed() == vehicles[14].getSpeed());
    }
}
