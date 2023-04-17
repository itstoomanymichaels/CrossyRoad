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

    private Log branchlog = new BranchLog(0, 0, 200, 100, 14, "L",
            Resources.getSystem());
    private Log smoothlog = new SmoothLog(0, 0, 200, 100, 14, "L",
            Resources.getSystem());
//    private GameView gv;
//    @Before
//    public void setUp() {
//        // Create a mock object
//        gv = mock(GameView.class);
//    }

    @Test
    public void differentImage() {
        assertEquals(smoothlog.getLog() == branchlog.getLog(), false);
    }
    @Test
    public void gameWinScreen(){
        try {
            // Replace "com.example.MyClass" with the fully qualified name of your class
            Class.forName("com.example.GameWin");
        } catch (ClassNotFoundException e) {
            // If the class is not found, the test will fail
            assertNotNull("GameWin does not exist", null);
        }
    }



}
