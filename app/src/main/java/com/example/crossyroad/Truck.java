package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Truck extends Vehicle {

    private Bitmap truck;
    private final int width;

    public Truck(int x, int y, int screenY, int screenX, String direction,
                 Resources res) {
        super(x, y, screenY, screenX, 12, direction);
        createTruck(res);
        width = 4 * screenX / 20;
    }
    @Override
    public void drive() {
        x += speed;
        if (direction.equals("L")) {
            if ((x + width) <= 0) {
                x = screenX;
            }
        } else {
            if (x >= screenX) x = -width - (6 * screenX / 20);
        }
    }
    @Override
    public Bitmap getVehicle() {
        return Bitmap.createScaledBitmap(truck, width, height, false);
    }

    @Override
    public boolean isCollided(Frog frog) {
        Rect f = new Rect(frog.getX(), frog.getY(), frog.getX() + frog.getWidth(),
                frog.getY() + frog.getHeight());
        Rect c = new Rect(x, y, x + width, y + height);
        return Rect.intersects(f, c);
    }

    private void createTruck(Resources res) {
        if (Math.random() < 0.5) {
            if (direction.equals("R")) {
                this.truck = BitmapFactory.decodeResource(res, R.drawable.lrt);
            } else {
                this.truck = BitmapFactory.decodeResource(res, R.drawable.rrt);
            }
        } else {
            if (direction.equals("R")) {
                this.truck = BitmapFactory.decodeResource(res, R.drawable.lbt);
            } else {
                this.truck = BitmapFactory.decodeResource(res, R.drawable.rbt);
            }
        }
    }

}
