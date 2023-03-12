
package com.example.crossyroad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameView extends SurfaceView implements Runnable {


    private Thread thread;
    private boolean isPlaying, isGameOver = false;
    private int screenX;
    private int screenY;
    private String name;
    private String difficulty;
    private Vehicle[] vehicles;
    private int life;

    private int score = 0;
    public static float screenRatioX, screenRatioY;
    private Paint paint;
    //private Bird[] birds;   //change bird to vehicles
    private SharedPreferences prefs;
    private Random random;
    private SoundPool soundPool;
    private GameScreen activity;
    private Frog frog;
    //private Background background1, background2;

    public GameView(GameScreen activity, int screenX, int screenY, String name, String difficulty, int life, int sprite) {
        super(activity);

        this.activity = activity;

        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;
        this.name = name;
        this.difficulty = difficulty;
        this.life = life;
        this.frog = new Frog( screenY, screenX, getResources(), sprite);
        Road ro = new Road(screenY, screenX, getResources());
        this.vehicles = ro.getVehicles();
        paint = new Paint();


    }

    @Override
    public void run() {
        while (isPlaying) {
            update ();
            draw ();
            sleep ();
        }
    }

    private void update () {
/**
        if (flight.isGoingUp)
            flight.y -= 30 * screenRatioY;
        else
            flight.y += 30 * screenRatioY;

        if (flight.y < 0)
            flight.y = 0;

        if (flight.y >= screenY - flight.height)
            flight.y = screenY - flight.height;
 **/
        for (Vehicle vehicle : vehicles) {
             if (vehicle.getVehicle() != null) {
                vehicle.move();
             }
        }

    }

    private void draw () {

        if (getHolder().getSurface().isValid()) {

            Canvas canvas = getHolder().lockCanvas();

            paint.setColor(Color.parseColor("#3CB371"));
            canvas.drawRect(0, 3*screenY/36, screenX, 6*screenY/36, paint );
            paint.setColor(Color.parseColor("#4682B4"));
            canvas.drawRect(0, 6*screenY/36, screenX, 20*screenY/36, paint );
            paint.setColor(Color.parseColor("#D2B48C"));
            canvas.drawRect(0, 20*screenY/36, screenX, 22*screenY/36, paint );
            paint.setColor(Color.parseColor("#778899"));
            canvas.drawRect(0, 22*screenY/36, screenX, 34*screenY/36, paint );
            paint.setColor(Color.parseColor("#BDB76B"));
            canvas.drawRect(0, 34*screenY/36, screenX, screenY, paint );

            if (isGameOver) {
                isPlaying = false;
                getHolder().unlockCanvasAndPost(canvas);
                //saveIfHighScore();
                waitBeforeExiting ();
                return;
            }
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getVehicle() != null) {
                    canvas.drawBitmap(vehicle.getVehicle(), vehicle.getX(), vehicle.getY(), paint);
                }
            }
            canvas.drawBitmap(frog.getFrog(), frog.getX(), frog.getY(), paint);

            getHolder().unlockCanvasAndPost(canvas);

        }

    }

    private void waitBeforeExiting() {

        try {
            Thread.sleep(3000);
            activity.startActivity(new Intent(activity, Welcome.class));
            activity.finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleep () {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume () {

        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause () {

        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        /**switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < screenX / 2) {
                    frog.isGoingUp = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                flight.isGoingUp = false;
                break;
        }**/

        return true;
    }
}
