package com.example.crossyroad;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class Sprint5AshrafUnitTests {
    private int score = 500;
    private int highScore = 0;
    private int screenY = 720;
    private int screenX = 360;
    private int frogY = 710;
    private int frogX = 170;
    private boolean isGameOver = false;

    public void checkForGoal() {
        if (frogY < 6 * screenY / 36) {
            score += 1500;
            highScore = score;
            isGameOver = true;
            return;
        }
    }

    public boolean boundsReached() {
        return  (frogX < 0 || (frogX > screenX - 36));
    }


    @Test
    public void goalTilePointsTest() {
        while (!isGameOver) {
            checkForGoal();
            frogY -= (screenY / 20); // move towards goal
        }
        assertEquals(highScore, 2000);
    }

    @Test
    public void outOfBoundsTest() {
        while (frogX >= 0) {
            frogX -= (screenY / 20); // move towards bound
        }
        assertEquals(true, boundsReached());
        while (frogX <= screenX - 36) {
            frogX += (screenY / 20); // move towards other bound
        }
        assertEquals(true, boundsReached());
    }
}
