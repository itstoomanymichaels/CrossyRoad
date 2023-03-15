package com.example.crossyroad;

import static org.mockito.Mockito.mock;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GenerateVehiclesTest {
    private Vehicle vehicle;

    @Before
    public void setup(){
        vehicle = mock(Car.class);
    }

    @Test
    public void testVehicleGeneration() {
        Assert.assertNotNull(vehicle);
    }
}

