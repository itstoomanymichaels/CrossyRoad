package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(AndroidJUnit4.class)
public class SpriteCheckedTest {

    private ConfigScreen cs;
    @Before
    public void setUp() {
        //create mock object
        cs = mock(ConfigScreen.class);
    }

    @Test
    public void validSprite() {
        //checks if sprite is selected
        Mockito.when(cs.spriteIsSelected(-1)).thenReturn(false);
        Mockito.when(cs.spriteIsSelected(1)).thenReturn(true);
        Mockito.when(cs.spriteIsSelected(2)).thenReturn(true);
        Mockito.when(cs.spriteIsSelected(3)).thenReturn(true);

        assertEquals(false, cs.spriteIsSelected(-1));
        assertEquals(true, cs.spriteIsSelected(1));
        assertEquals(true, cs.spriteIsSelected(2));
        assertEquals(true, cs.spriteIsSelected(3));

    }
}
