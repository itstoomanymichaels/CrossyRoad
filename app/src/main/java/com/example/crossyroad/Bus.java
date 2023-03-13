package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Bus extends Vehicle{
    private Bitmap car;

    private int width;
    public Bus(int x, int y, int screenY, int screenX, int speed, String direction, Resources res) {

        super(x, y, screenY, screenX, speed, direction);
        if (direction.equals("R")) {
            this.car = BitmapFactory.decodeResource(res, R.drawable.lb);
        } else {
            this.car = BitmapFactory.decodeResource(res, R.drawable.rb);
        }
        width = 5 * screenX / 20;
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
        x += speed;
        if (direction.equals("L")) {
            if ((x + width) <= 0) {
                x = screenX + (5 * screenX/20);
            }
        } else {
            if (x >= screenX) {
                x = 0 - width - (5 * screenX/20);
            }
        }
    }
}
