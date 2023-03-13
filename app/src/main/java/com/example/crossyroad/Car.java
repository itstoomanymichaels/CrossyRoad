package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Car extends Vehicle {

    private Bitmap car;
    private int width;

    public Car(int x, int y, int screenY, int screenX, int speed, String direction, Resources res) {

        super(x, y, screenY, screenX, speed, direction);
        if (Math.random() < 0.5) {
            if (direction.equals("R")) {
                this.car = BitmapFactory.decodeResource(res, R.drawable.lrc);
            } else {
                this.car = BitmapFactory.decodeResource(res, R.drawable.rrc);
            }
        } else {
            if (direction.equals("R")) {
                this.car = BitmapFactory.decodeResource(res, R.drawable.lyc);
            } else {
                this.car = BitmapFactory.decodeResource(res, R.drawable.ryc);
            }
        }
        width = 3 * screenX / 20;
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
                x = screenX + screenX / 20;
            }
        } else {
            if (x >= screenX) {
                x = 0 - screenX / 20 - width;
            }
        }
    }


}
