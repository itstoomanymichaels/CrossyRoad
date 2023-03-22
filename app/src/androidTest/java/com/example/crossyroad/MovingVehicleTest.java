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
public class MovingVehicleTest {
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
        Mockito.when(car.getX()).thenReturn(screenX + screenX / 20);
        car.drive();
        assertEquals(420, car.getX());

        Mockito.when(car.getX()).thenReturn(0 - screenX / 20 - width);
        car.drive();
        assertEquals(-30, car.getX());

    }

    @Test
    public void testBus() {

        int speed = 10;
        int width = 20;
        int screenX = 400;

        //run Mockito tests
        Mockito.when(bus.getX()).thenReturn(screenX + (5 * screenX / 20));
        car.drive();
        assertEquals(500, bus.getX());

        Mockito.when(bus.getX()).thenReturn(0 - width - (5 * screenX / 20));
        car.drive();
        assertEquals(-120, bus.getX());

    }

    @Test
    public void testTruck() {

        int speed = 10;
        int width = 20;
        int screenX = 400;

        //run Mockito tests
        Mockito.when(truck.getX()).thenReturn(screenX);
        car.drive();
        assertEquals(400, truck.getX());

        Mockito.when(truck.getX()).thenReturn(0 - width - (6 * screenX / 20));
        car.drive();
        assertEquals(-140, truck.getX());

    }
}
