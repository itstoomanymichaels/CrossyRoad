package com.example.crossyroad;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import android.widget.TextView;

import static org.mockito.Mockito.mock;


@RunWith(AndroidJUnit4.class)
public class Sprint5TestsTimothy {

    private GameWin gw;
    private TextView congratsText;
    private Log log;
    private Frog frog;
    @Before
    public void setUp() {
        gw = mock(GameWin.class);
        congratsText = mock(TextView.class);
        log = mock(BranchLog.class);
        frog = mock(Frog.class);
    }

    @Test
    public void congratsShown() {
        Mockito.when(gw.getCongrats()).thenReturn(congratsText);
        assertTrue(gw.getCongrats() != null);
    }

    @Test
    public void getOnLog() {
        Mockito.when(log.isCollided(frog)).thenReturn(true);
        assertTrue(log.isCollided(frog));
    }
}
