package com.example.crossyroad;

import android.content.res.Resources;

public class River {

    private Log[] logs = new Log[21];

    public River(int screenY, int screenX, Resources res) {
        for (int i = 0; i < 21; i++) {
            Log v;
            //Each if block for 1 lane, each lane corresponds to a type of vehicle
            //Position, speed, and direction are passed to generate vehicle
            if (i < 3) {
                v = new SmoothLog(i * 8 * screenX / 20, 18 * screenY / 36, screenY, screenX,
                        3, "R", res);
            } else if (i < 6) {
                v = new BranchLog(((i - 3) * 10 + 3) * screenX / 20, 16 * screenY / 36,
                        screenY, screenX, 14, "L", res);
            } else if (i < 9) {
                v = new SmoothLog((i - 6) * 8 * screenX / 20, 14 * screenY / 36,
                        screenY, screenX, 9, "R", res);
            } else if (i < 12) {
                v = new BranchLog(((i - 9) * 10 + 3) * screenX / 20, 12 * screenY / 36,
                        screenY, screenX, 17, "L", res);
            } else if (i < 15) {
                v = new SmoothLog((i - 12) * 8 * screenX / 20, 10 * screenY / 36,
                        screenY, screenX, 5, "R", res);
            } else if (i < 18) {
                v = new BranchLog(((i - 15) * 10 + 3) * screenX / 20, 8 * screenY / 36,
                        screenY, screenX, 11, "L", res);
            } else {
                v = new SmoothLog((i - 18) * 8 * screenX / 20, 6 * screenY / 36,
                        screenY, screenX, 11, "R", res);
            }
            logs[i] = v;
        }
    }

    public Log[] getLogs() {
        return logs;
    }


}
