package com.example.crossyroad;

import android.graphics.Bitmap;

public abstract class Vehicle {
    protected int height;
    protected int screenX;
    protected int x;
    protected int y;
    protected Bitmap vehicle;
    protected int speed;
    protected String direction;

    public Vehicle(int x, int y, int screenY, int screenX, int speed, String direction) {
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

    public abstract int getX();
    public abstract int getY();

    public abstract Bitmap getVehicle();
    public abstract int move();
}
