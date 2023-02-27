package com.example.crossyroad;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class GoalTileTest {
    @Test
    public void testGoalTileIdExists() {
        // Obtain a reference to the app's context
        Context context = ApplicationProvider.getApplicationContext();

        // Check if the "goal" ID exists in the layout file
        assertNotNull("goal ID not found in activity_game_screen layout file", context.getResources().getIdentifier("goal", "id", context.getPackageName()));
    }
}