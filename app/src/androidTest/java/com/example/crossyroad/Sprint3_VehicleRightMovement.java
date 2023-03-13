package com.example.crossyroad;

import static org.junit.Assert.assertEquals;

import android.content.res.Resources;

import org.junit.Test;

public class Sprint3_VehicleRightMovement {
    private Vehicle v = new Car(40, 0, 200, 100, 10, "R",
            Resources.getSystem());

    @Test
    public void vehicleMovesRightTest() {
        int x = v.getX();

        v.move();

        assertEquals(v.getX() > x, true);

    }
}
