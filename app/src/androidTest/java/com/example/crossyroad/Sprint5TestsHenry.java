package com.example.crossyroad;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import android.content.res.Resources;
import static org.mockito.Mockito.mock;

public class Sprint5TestsHenry {

    private GameWin gw;

    @Before

    public void setUp() {
        gw = mock(GameWin.class);
    }

    @Test

    public void restartButton() {
        assertTrue(gw.isRestart());
    }

    @Test

    public void exitButton() {
        assertTrue(gw.isQuit());
    }


}
