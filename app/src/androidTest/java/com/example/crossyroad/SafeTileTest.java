package com.example.crossyroad;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SafeTileTest {
    @Test
    public void testSafeTileIdExists() {
        // Obtain a reference to the app's context
        Context context = ApplicationProvider.getApplicationContext();

        // Check if the "SafeTile" ID exists in the layout file
        assertNotNull("SafeTile ID not found in activity_game_screen layout file", context.getResources().getIdentifier("SafeTile", "id", context.getPackageName()));
    }
}