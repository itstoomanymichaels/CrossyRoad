package com.example.crossyroad;

import static org.mockito.Mockito.mock;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(AndroidJUnit4.class)
public class VehicleCollisionTest {
    private Vehicle v1;
    private Vehicle v2;
    private int screenX = 100;
    @Before
    public void setup(){
        v1 = mock(Car.class);
        v2 = mock(Car.class);
    }

    @Test
    public void testVehicleGeneration() {
        int carX = 20;
        int carWidth = 3 * screenX / 20;
        int car2X = 0;
        int car2Width = 3 * screenX / 20;
        for (int i = 0; i < screenX; i++) {
            Mockito.when(v1.move()).thenReturn(carX += v1.speed);
            Mockito.when(v2.move()).thenReturn(car2X += v2.speed);
            if (carX + carWidth >= car2X + car2Width) {
                assert(true);
            } else {
                assert(false);
            }
        }
    }
}

