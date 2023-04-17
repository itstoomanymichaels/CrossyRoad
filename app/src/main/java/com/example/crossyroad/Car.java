package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Car extends Vehicle {

    private Bitmap car;
    private int width;

    public Car(int x, int y, int screenY, int screenX, int speed, String direction, Resources res) {

        super(x, y, screenY, screenX, speed, direction);
        createCar(res);
        this.width = 3 * screenX / 20;

    }
    @Override
    public void drive() {
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

    @Override
    public Bitmap getVehicle() {
        return Bitmap.createScaledBitmap(car, width, height, false);
    }

    @Override
    public boolean isCollided(Frog frog) {
        Rect f = frog.getRect();
        Rect c = new Rect(x, y, x + width, y + height);
        return Rect.intersects(f, c);
    }



    private void createCar(Resources res) {
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
    }


}
