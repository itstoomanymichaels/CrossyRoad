
package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
public class Frog {

    private int x;
    private int y;
    private int width;
    private int height;
    Bitmap frog;

    public Frog(int screenY, int screenX, Resources res, int sprite) {

        frog = BitmapFactory.decodeResource(res, R.drawable.frog);

        width = screenX / 20;
        height = 2 * screenY / 36 - 30;

        frog = Bitmap.createScaledBitmap(frog, width, height, false);
        y = screenY - height - 15;
        x = screenX / 2 - width / 2;

    }

    public int getX () {
        return x;
    }
    public int getY () {
        return y;
    }
    public Bitmap getFrog () {
        return frog;
    }
}