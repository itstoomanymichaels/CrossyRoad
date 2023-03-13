
package com.example.crossyroad;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {


    private Thread thread;
    private boolean isPlaying, isGameOver = false;
    private int screenX;
    private int screenY;
    private String name;
    private String difficulty;
    private Vehicle[] vehicles;
    private int life;

    //variables for score
    private int score;
    private int max;
    private Paint paint;
    //private Bird[] birds;   //change bird to vehicles
    private GameScreen activity;
    private Frog frog;

    public GameView(GameScreen activity, int screenX, int screenY, String name, String difficulty, int life, Frog frog) {
        super(activity);

        this.activity = activity;

        this.screenX = screenX;
        this.screenY = screenY;
        this.score = 0;
        this.name = name;
        this.difficulty = difficulty;
        this.life = life;
        this.frog = frog;
        frog.setSize(screenX, screenY);
        Road ro = new Road(screenY, screenX, getResources());
        this.vehicles = ro.getVehicles();
        paint = new Paint();
        this.max = screenY;

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
        for (Vehicle vehicle : vehicles) {
             if (vehicle.getVehicle() != null) {
                vehicle.move();
             }
        }

        if (frog.getY() < max) {
            if (frog.getY() < 22*screenY/36) {
                score += 500;
            } else if (frog.getY() < 24*screenY/36) {
                score += 300;
            } else if (frog.getY() < 26*screenY/36) {
                score += 100;
            } else if (frog.getY() < 28*screenY/36) {
                score += 500;
            } else if (frog.getY() < 30*screenY/36) {
                score += 300;
            } else if (frog.getY() < 32*screenY/36) {
                score += 100;
            }
            max = frog.getY();
        }

    }

    private void draw () {

        if (getHolder().getSurface().isValid()) {

            Canvas canvas = getHolder().lockCanvas();
            paint.setColor(Color.BLACK);
            canvas.drawRect(0, 0, screenX, 3*screenY/36, paint);
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

            paint.setColor(Color.parseColor("#BDB76B"));
            paint.setTextSize(screenY/36);
            canvas.drawText("Name: " + name, 0, screenY/36, paint);
            paint.setTextSize(screenY/36);
            canvas.drawText("Difficulty: " + difficulty, screenX/2,screenY/36, paint);
            paint.setTextSize(screenY/36);
            canvas.drawText("Life: " + life, 0, 2 * screenY/36, paint);
            paint.setTextSize(screenY/36);
            canvas.drawText("Score: " + score, screenX/2,2 * screenY/36, paint);

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
            Thread.sleep(80);
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
