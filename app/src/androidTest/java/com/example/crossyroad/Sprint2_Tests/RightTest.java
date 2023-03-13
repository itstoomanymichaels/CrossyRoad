package com.example.crossyroad;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import android.content.res.Resources;

@RunWith(AndroidJUnit4.class)
public class RightTest {
    private Frog f = new Frog(200, 100, Resources.getSystem(), 1);
    @Test
    public void rightTest() {
        int x = f.getX();

        f.moveRight();

        assertEquals(f.getX() > x, true);

    }
}
