package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Truck extends Vehicle{

    private Bitmap car;
    private int gap;

    public Truck(int x, int y, int screenY, int screenX, int speed, String direction, Resources res, int gap) {
        super(x, y, screenY, screenX, speed, direction);
        this.gap = gap;
        if (Math.random() < 0.5) {
            if (direction.equals("R")) {
                this.car = BitmapFactory.decodeResource(res, R.drawable.lrt);
            } else {
                this.car = BitmapFactory.decodeResource(res, R.drawable.rrt);
            }
        } else {
            if (direction.equals("R")) {
                this.car = BitmapFactory.decodeResource(res, R.drawable.lbt);
            } else {
                this.car = BitmapFactory.decodeResource(res, R.drawable.rbt);
            }
        }
        int width = 4 * screenX / 20;
        height = 2 * screenY / 36 - 15;

        car = Bitmap.createScaledBitmap(car, width, height, false);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Bitmap getVehicle() {
        return car;
    }

    @Override
    public void move() {

    }
}
