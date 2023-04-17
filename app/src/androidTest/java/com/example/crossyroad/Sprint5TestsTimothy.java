package com.example.crossyroad;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import android.content.res.Resources;
import android.graphics.Rect;
import android.widget.TextView;

import static org.mockito.Mockito.mock;


public class Sprint5TestsTimothy {

    private GameWin gw;
    private TextView congratsText;
    private Log log = new BranchLog(0, 0, 200, 100, 14, "L",
            Resources.getSystem());
    private Frog frog = new Frog(0,0, Resources.getSystem(), 1);
    Rect f = new Rect(frog.getX(), frog.getY(), frog.getX() + frog.getWidth(),
            frog.getY() + frog.getHeight());
    Rect c = new Rect(log.getX(), log.getY(), log.getX() + log.getWidth(), log.getY() + log.getHeight());

    @Before

    public void setUp() {
        gw = mock(GameWin.class);
        congratsText = mock(TextView.class);
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
