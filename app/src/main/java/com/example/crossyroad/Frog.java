
package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
public class Frog {

    private int x;
    private int y;
    private int width;
    private int height;
    private int screenX;
    private int screenY;
    private Bitmap frog;

    public Frog(int screenY, int screenX, Resources res, int sprite) {
        //sets sprite to appear in GameView
        if (sprite == 1) {
            frog = BitmapFactory.decodeResource(res, R.drawable.frog);
        } else if (sprite == 2) {
            frog = BitmapFactory.decodeResource(res, R.drawable.frog2);
        } else {
            frog = BitmapFactory.decodeResource(res, R.drawable.frog3);
        }
        this.screenX = screenX;
        this.screenY = screenY;

        this.y = screenY - height - 15;
        this.x = screenX / 2 - width / 2;

    }

    public void moveRight() {
        x += screenX / 20;
        if (x >= screenX - width) {
            x = screenX - width;
        }
    }

    public void moveLeft() {
        x -= screenX / 20;
        if (x < 0) {
            x = 0;
        }
    }

    public void moveUp() {
        y -= 2 * screenY / 36;
        if (y <= 3 * screenY / 36) {
            y = 3 * screenY / 36;
        }
    }

    public void moveDown() {
        y += 2 * screenY / 36;
        if (y > screenY - height) {
            y = screenY - height;
        }
    }

    public void setSize(int xx, int yy) {
        //sets height, width, x-coordinate, and y-coordinate of frog
        width = xx / 20;
        height = xx / 20;

        frog = Bitmap.createScaledBitmap(frog, width, height, false);
        this.y = yy - height - 15;
        this.x = xx / 2 - width / 2;
        this.screenX = xx;
        this.screenY = yy;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Bitmap getFrog() {
        return frog;
    }
}