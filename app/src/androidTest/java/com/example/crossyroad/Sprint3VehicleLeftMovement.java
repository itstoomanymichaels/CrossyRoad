package com.example.crossyroad;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import android.content.res.Resources;

@RunWith(AndroidJUnit4.class)
public class Sprint3VehicleLeftMovement {

    private Vehicle v = new Car(80, 0, 200, 100, 10, "L",
            Resources.getSystem());

    @Test
    public void vehicleMovesLeftTest() {
        int x = v.getX();

        v.drive();

        assertEquals(v.getX() < x, true);

    }
}