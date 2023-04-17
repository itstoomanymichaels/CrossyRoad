package com.example.crossyroad;

import android.content.res.Resources;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(AndroidJUnit4.class)
public class Sprint5WonjinUnitTests {

    private BranchLog branchlog = new BranchLog(0, 0, 200, 100, 14, "L",
            Resources.getSystem());
    private SmoothLog smoothlog = new SmoothLog(0, 0, 200, 100, 14, "L",
            Resources.getSystem());

    @Test
    public void differentImage() {
        assertEquals(smoothlog.getID() == branchlog.getID(), false);
    }
    @Test
    public void gameWinScreen() {
        try {
            Class.forName("com.example.crossyroad.GameWin");
        } catch (ClassNotFoundException e) {
            // If the class is not found, the test will fail
            assertNotNull("GameWin does not exist", null);
        }
    }



}
