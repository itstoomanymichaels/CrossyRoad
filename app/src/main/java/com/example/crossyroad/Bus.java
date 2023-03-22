package com.example.crossyroad;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Bus extends Vehicle {
    private Bitmap bus;
    private int width;
    public Bus(int x, int y, int screenY, int screenX, int speed, String direction, Resources res) {
        super(x, y, screenY, screenX, speed, direction);
        createBus(res);
        width = 5 * screenX / 20;

    }
    @Override
    public void drive() {
        x += speed;
        if (direction.equals("L")) {
            if ((x + width) <= 0) {
                x = screenX + (5 * screenX / 20);
            }
        } else {
            if (x >= screenX) {
                x = -width - (5 * screenX / 20);
            }
        }
    }
    @Override
    public Bitmap getVehicle() {
        return Bitmap.createScaledBitmap(bus, width, height, false);
    }

    @Override
    public boolean isCollided(Frog frog) {
        Rect f = new Rect(frog.getX(), frog.getY(), frog.getX() + frog.getWidth(),
                frog.getY() + frog.getHeight());
        Rect c = new Rect(x, y, x + width, y + height);
        return Rect.intersects(f, c);
    }
    private void createBus(Resources res) {
        if (direction.equals("R")) {
            this.bus = BitmapFactory.decodeResource(res, R.drawable.lb);
        } else {
            this.bus = BitmapFactory.decodeResource(res, R.drawable.rb);
        }
    }

}
