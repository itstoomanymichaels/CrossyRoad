package com.example.crossyroad;

import android.content.res.Resources;

public class Road {
    //Vehicles is a list of all vehicles on road across all lanes
    private Vehicle[] vehicles = new Vehicle[19];

    public Road(int screenY, int screenX, Resources res) {
        for (int i = 0; i < 19; i++) {
            Vehicle v;
            //Each if block for 1 lane, each lane corresponds to a type of vehicle
            //Position, speed, and direction are passed to generate vehicle
            if (i < 4) {
                v = new Car(i * 6 * screenX / 20, 32 * screenY / 36, screenY, screenX,
                        5, "L", res);
            } else if (i < 7) {
                v = new Car((i - 4) * 8 * screenX / 20, 26 * screenY / 36, screenY, screenX,
                        5, "R", res);
            } else if (i < 10) {
                v = new Truck((i - 7) * 8 * screenX / 20, 24 * screenY / 36, screenY, screenX,
                        "L", res, 4);
            } else if (i < 13) {
                v = new Truck((i - 10) * 10 * screenX / 20, 30 * screenY / 36, screenY,
                        screenX, "R", res, 6);
            } else if (i < 16) {
                v = new Bus((i - 13) * 10 * screenX / 20, 28 * screenY / 36, screenY, screenX,
                        20, "L", res);
            } else {
                v = new Bus((i - 16) * 10 * screenX / 20, 22 * screenY / 36, screenY, screenX,
                        20, "R", res);
            }
            vehicles[i] = v;
        }
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

}
