package com.example.crossyroad;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import android.content.res.Resources;
import static org.mockito.Mockito.mock;


public class Sprint5TestsTimothy {

    private GameWin gw;
    private Log log = new BranchLog(0, 0, 200, 100, 14, "L",
            Resources.getSystem());
    private Frog frog = new Frog(0,0, Resources.getSystem(), 1);


    @Before

    public void setUp() {
        gw = mock(GameWin.class);
    }

    @Test

    public void congratsShown() {
        assertTrue(gw.getCongrats() != null);
    }

    @Test

    public void getOnLog() {
        assertTrue(log.isCollided(frog));
    }

}
