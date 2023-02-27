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
public class DifficultyTest {
    private ConfigScreen cs;

    @Before
    public void setUp() {
        // Create a mock object
        cs = mock(ConfigScreen.class);

    }

    @Test
    //checks if difficulty is selected.
    public void validDifficulty() {
        Mockito.when(cs.difficultyIsSelected(-1)).thenReturn(false);
        assertEquals(false, cs.difficultyIsSelected(-1));

        Mockito.when(cs.difficultyIsSelected(1)).thenReturn(true);
        assertEquals(true, cs.difficultyIsSelected(1));
    }

}
