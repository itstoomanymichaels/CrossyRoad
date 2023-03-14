package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Car extends Vehicle {

    private Bitmap car;
    private int width;
    private int height;


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
        this.width = 3 * screenX / 20;
        this.height = 2 * screenY / 36 - 15;

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
        return Bitmap.createScaledBitmap(car, width, height, false);
    }

    @Override
    public int move() {
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
        return x;
    }


}
