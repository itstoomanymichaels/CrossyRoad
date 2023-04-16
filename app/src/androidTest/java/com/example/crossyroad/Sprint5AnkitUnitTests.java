package com.example.crossyroad;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import android.content.res.Resources;

public class Sprint5AnkitUnitTests {

    private Log branchlog = new BranchLog(0, 0, 200, 100, 14, "L",
            Resources.getSystem());
    private Log smoothlog = new SmoothLog(0, 0, 200, 100, 5, "L",
            Resources.getSystem());

    @Test

    public void differentSpeed() {
        assertEquals(smoothlog.getSpeed() == branchlog.getSpeed(), false);
    }

    @Test

    public void differentSurfaceArea() {
        int branchlogArea = branchlog.getHeight() * branchlog.getWidth();
        int smoothlogArea = smoothlog.getHeight() * smoothlog.getWidth();

        assertEquals(branchlogArea == smoothlogArea, false);
    }


}
