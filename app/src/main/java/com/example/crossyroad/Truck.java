package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Truck extends Vehicle {

    private Bitmap car;
    private int gap;
    private int width;

    public Truck(int x, int y, int screenY, int screenX, String direction,
                 Resources res, int gap) {
        super(x, y, screenY, screenX, 12, direction);
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
        width = 4 * screenX / 20;
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
    public int move() {
        x += speed;
        if (direction.equals("L")) {
            if ((x + width) <= 0) {
                x = screenX;
            }
        } else {
            if (x >= screenX) {
                x = 0 - width - (6 * screenX / 20);
            }
        }
        return x;
    }
}
