package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
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
public class movingVehicleTest {
    private Car car;
    private Bus bus;
    private Truck truck;

    @Before
    public void setUp() {
        // Create a mock object
        car = mock(Car.class);
        bus = mock(Bus.class);
        truck = mock(Truck.class);
    }

    @Test
    public void testCar() {

        int width = 10;
        int screenX = 400;

        //run Mockito tests
        Mockito.when(car.move()).thenReturn(screenX + screenX / 20);
        assertEquals(420, car.move());

        Mockito.when(car.move()).thenReturn(0 - screenX / 20 - width);
        assertEquals(-30, car.move());

    }

    @Test
    public void testBus() {

        int speed = 10;
        int width = 20;
        int screenX = 400;

        //run Mockito tests
        Mockito.when(bus.move()).thenReturn(screenX + (5 * screenX / 20));
        assertEquals(500, bus.move());

        Mockito.when(bus.move()).thenReturn(0 - width - (5 * screenX / 20));
        assertEquals(-120, bus.move());

    }

    @Test
    public void testTruck() {

        int speed = 10;
        int width = 20;
        int screenX = 400;

        //run Mockito tests
        Mockito.when(truck.move()).thenReturn(screenX);
        assertEquals(400, truck.move());

        Mockito.when(truck.move()).thenReturn(0 - width - (6 * screenX / 20));
        assertEquals(-140, truck.move());

    }
}
