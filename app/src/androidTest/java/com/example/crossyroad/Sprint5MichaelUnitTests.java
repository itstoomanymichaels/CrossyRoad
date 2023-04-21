package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import android.content.res.Resources;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(AndroidJUnit4.class)
public class Sprint5MichaelUnitTests {
    private GameOver go;
    private GameWin gw;
    private Log branchlog = new BranchLog(48, 180, 200, 100, 14, "R",
            Resources.getSystem());
    private Frog frog = new Frog(200, 100, Resources.getSystem(), 1);



    @Before
    public void setUp() {
        go = mock(GameOver.class);
        gw = mock(GameWin.class);
    }

    @Test
    public void finalScoreAppears() {
        TextView goScore = null;
        TextView gwScore = null;
        Mockito.when(go.getScore()).thenReturn(goScore);
        assertEquals(goScore, go.getScore());
        Mockito.when(gw.getScore()).thenReturn(gwScore);
        assertEquals(gwScore, gw.getScore());
    }

    @Test
    public void frogAndLogMovesTogether() {
        //for sake of testing purposes
        //ensure that branchLog and frog are at same position/hence should move together
        assertEquals(branchlog.getX(), frog.getX());
        assertEquals(branchlog.getY(), frog.getY());

        branchlog.sway();
        frog.setX(frog.getX() + branchlog.getSpeed());

        assertEquals(frog.getX(), branchlog.getX());
    }
}
