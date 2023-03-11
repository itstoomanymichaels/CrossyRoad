package com.example.crossyroad;

import android.graphics.Bitmap;

public abstract class Vehicle {
    protected int height;
    Bitmap vehicle;
    protected int speed;

    Vehicle(int screenY, int speed) {
        this.height = 2 * screenY / 36 - 15;
        this.speed = speed;
    }

    protected int getSpeed(){
        return speed;
    }
    protected abstract Bitmap getVehicle ();
}
