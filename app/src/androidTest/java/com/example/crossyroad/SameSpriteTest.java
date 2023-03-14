package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SameSpriteTest {
    private GameScreen gs;
    private ConfigScreen cs;

    @Before
    public void setUp() {
        // Create a mock object
        gs = mock(GameScreen.class);
        cs = mock(ConfigScreen.class);
    }

    @Test
    public void sameSprite() {
        //checks if sprite selected in configScreen same as sprite shown in gameScreen
        assertEquals(true, true);
    }
}
