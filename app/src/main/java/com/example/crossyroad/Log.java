package com.example.crossyroad;

import android.graphics.Bitmap;

public abstract class Log {

    protected int height;
    protected int screenX;
    protected int x;
    protected int y;
    protected Bitmap log;
    protected int speed;
    protected String direction;

    public Log(int x, int y, int screenY, int screenX, int speed, String direction) {
        this.height = 2 * screenY / 36 - 15;
        this.screenX = screenX;
        this.x = x;
        this.y = y;
        this.direction = direction;
        if (direction.equals("R")) {
            this.speed = speed;
        } else if (direction.equals("L")) {
            this.speed = -speed;
        } else {
            this.speed = 0;
        }
    }
    public abstract Bitmap getLog();
    public abstract void sway();

    public abstract boolean isCollided(Frog frog);

    public int getSpeed() {
        return speed;
    };

    public abstract int getHeight();

    public abstract int getWidth();
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}
