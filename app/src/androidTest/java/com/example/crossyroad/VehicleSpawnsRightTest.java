package com.example.crossyroad;

import android.content.res.Resources;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class VehicleSpawnsRightTest {
    private Vehicle v = new Car(115, 0, 200, 100, 10, "L",
            Resources.getSystem());

    @Test
    public void vehicleSpawnsLeftTest() {
        int carX = v.getX();
        int tracker = v.getX();
        while (carX > 0) {
            carX -= v.getSpeed();
            v.drive();
            tracker = v.getX();
        }
        assertEquals(true, carX < tracker);
    }

}
