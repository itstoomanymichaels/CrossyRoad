package com.example.crossyroad;



import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Sprint4RespawnTest {

    // driving logic to test
    public int drive(int x, int speed, int width, int screenX, String direction) {
        if (direction.equals("L")) {
            x -= speed;
            if ((x + width) <= 0) {
                x = screenX + screenX / 20;
            }
        } else {
            x += speed;
            if (x >= screenX) {
                x = -screenX / 20 - width;
            }
        }
        return x;
    }

    @Test
    public void testCar() {

        int speed = 5;
        int width = 10;
        int screenX = 400;
        int xPos = (5 - 4) * 8 * screenX / 20;

        for (int i = 0; i < 1000; i++) { // run 1000 frames
            xPos = drive(xPos, speed, width, screenX, "R");
        }

        if (xPos < screenX) { // check if vehicle is still on screen
            assert (true);
        } else {
            assert (false);
        }

        //test other direction
        xPos = 3 * 6 * screenX / 20;
        for (int i = 0; i < 1000; i++) { // run 1000 frames
            xPos = drive(xPos, speed, width, screenX, "L");
        }

        if ((xPos + width) > 0) { // check if vehicle is still on screen
            assert (true);
        } else {
            assert (false);
        }
    }

    @Test
    public void testBus() {

        int speed = 10;
        int width = 20;
        int screenX = 400;
        int xPos = (18 - 16) * 10 * screenX / 20;

        for (int i = 0; i < 1000; i++) { // run 1000 frames
            xPos = drive(xPos, speed, width, screenX, "R");
        }

        if (xPos < screenX) { // check if vehicle is still on screen
            assert (true);
        } else {
            assert (false);
        }

        //test other direction
        xPos = (14 - 13) * 10 * screenX / 20;
        for (int i = 0; i < 1000; i++) { // run 1000 frames
            xPos = drive(xPos, speed, width, screenX, "L");
        }

        if ((xPos + width) > 0) { // check if vehicle is still on screen
            assert (true);
        } else {
            assert (false);
        }
    }

    @Test
    public void testTruck() {

        int speed = 10;
        int width = 20;
        int screenX = 400;
        int xPos = (11 - 10) * 10 * screenX / 20;

        for (int i = 0; i < 1000; i++) { // run 1000 frames
            xPos = drive(xPos, speed, width, screenX, "R");
        }

        if (xPos < screenX) { // check if vehicle is still on screen
            assert (true);
        } else {
            assert (false);
        }

        //test other direction
        xPos = (15 - 13) * 10 * screenX / 20;
        for (int i = 0; i < 1000; i++) { // run 1000 frames
            xPos = drive(xPos, speed, width, screenX, "L");
        }

        if ((xPos + width) > 0) { // check if vehicle is still on screen
            assert (true);
        } else {
            assert (false);
        }
    }
}
