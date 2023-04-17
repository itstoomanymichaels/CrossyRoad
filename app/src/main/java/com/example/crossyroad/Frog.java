
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

        this.width = screenX / 20;
        this.height = screenX / 20;

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

    public int moveUp() {
        y -= 2 * screenY / 36;
        if (y <= 3 * screenY / 36) {
            y = 3 * screenY / 36;
        }
        return y;
    }

    public void moveDown() {
        y += 2 * screenY / 36;
        if (y > screenY - height) {
            y = screenY - height;
        }
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public boolean isDead() {
        return  (x < 0 || (x > screenX - width));
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Bitmap getFrog() {
        return frog;
    }

    public void setSize(int xx, int yy) {
        //sets height, width, x-coordinate, and y-coordinate of frog
        width = xx / 20;
        height = xx / 20;

        frog = Bitmap.createScaledBitmap(frog, width, height, false);
        this.y = yy - yy / 36 - height / 2;
        this.x = xx / 2 - width / 2;
        this.screenX = xx;
        this.screenY = yy;
    }
}