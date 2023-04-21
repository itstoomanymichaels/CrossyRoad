package com.example.crossyroad;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(AndroidJUnit4.class)
public class Sprint5TestsHenry {

    private GameWin gw;

    @Before

    public void setUp() {
        gw = mock(GameWin.class);
    }

    @Test

    public void restartButton() {
        Mockito.when(gw.isRestart()).thenReturn(true);
        assertTrue(gw.isRestart());
    }

    @Test

    public void exitButton() {
        Mockito.when(gw.isQuit()).thenReturn(true);
        assertTrue(gw.isQuit());
    }


}
