package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class SmoothLog extends Log {

    protected int width;
    protected Bitmap log;
    private int id = R.drawable.nbran;

    public SmoothLog(int x, int y, int screenY, int screenX, int speed, String direction,
                     Resources res) {
        super(x, y, screenY, screenX, speed, direction);
        this.log = BitmapFactory.decodeResource(res, R.drawable.nbran);
        width = 3 * screenX / 20;
    }

    public void sway() {
        x += speed;
        if (direction.equals("L")) {
            if ((x + width) <= 0) {
                x = screenX + screenX / 20;
            }
        } else {
            if (x >= screenX) {
                x = -screenX / 20 - width;
            }
        }
    }

    public Bitmap getLog() {
        return Bitmap.createScaledBitmap(log, width, height, false);
    }

    public boolean isCollided(Frog frog) {
        Rect f = frog.getRect();
        Rect c = new Rect(x, y, x + width, y + height);
        boolean ret = Rect.intersects(f, c);
        if (ret) {
            frog.setX(frog.getX() + speed);
        }
        return ret;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public int getID() {
        return id;
    }
    public int getSpeed() {
        return speed;
    }

}
