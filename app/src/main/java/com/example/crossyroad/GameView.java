
package com.example.crossyroad;


import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {


    private Thread thread;
    private boolean isPlaying = false;
    private boolean isGameOver = false;
    private int screenX;
    private int screenY;
    private String name;
    private String difficulty;
    private Vehicle[] vehicles;
    private int life;

    //variables for score
    private int score;
    //Is the maximum height that the frog has reached
    private int max;
    private Paint paint;
    private GameScreen activity;
    private Frog frog;

    public GameView(GameScreen activity, int screenX, int screenY, String name, String difficulty,
                    int life, Frog frog) {
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
        //Creates instance of road with all the vehicles in it
        Road ro = new Road(screenY, screenX, getResources());
        //Gets the list of all vehicles
        this.vehicles = ro.getVehicles();
        paint = new Paint();
        this.max = screenY;

    }

    @Override
    public void run() {
        //while game is not over, later implementation
        while (isPlaying) {
            update();
            draw();
            sleep();
        }
    }

    private void update() {
        //Moves all vehicles to next step
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicle() != null) {
                vehicle.move();
            }
        }

        //Updates score if frog has reached new height
        if (frog.getY() < max && frog.getY() > 20 * screenY / 36) {
            if (frog.getY() < 22 * screenY / 36) {
                score += 500;
            } else if (frog.getY() < 24 * screenY / 36) {
                score += 300;
            } else if (frog.getY() < 26 * screenY / 36) {
                score += 100;
            } else if (frog.getY() < 28 * screenY / 36) {
                score += 500;
            } else if (frog.getY() < 30 * screenY / 36) {
                score += 300;
            } else if (frog.getY() < 32 * screenY / 36) {
                score += 100;
            }
            max = frog.getY();
        }

    }

    private void draw() {
        //Draws everything
        if (getHolder().getSurface().isValid()) {

            Canvas canvas = getHolder().lockCanvas();
            //Creates 6 different rectangles, each 6 different colors, representing the 6 tiles
            paint.setColor(Color.BLACK);
            canvas.drawRect(0, 0, screenX, 3 * screenY / 36, paint);
            paint.setColor(Color.parseColor("#3CB371"));
            canvas.drawRect(0, 3 * screenY / 36, screenX, 6 * screenY / 36, paint);
            paint.setColor(Color.parseColor("#4682B4"));
            canvas.drawRect(0, 6 * screenY / 36, screenX, 20 * screenY / 36, paint);
            paint.setColor(Color.parseColor("#D2B48C"));
            canvas.drawRect(0, 20 * screenY / 36, screenX, 22 * screenY / 36, paint);
            paint.setColor(Color.parseColor("#778899"));
            canvas.drawRect(0, 22 * screenY / 36, screenX, 34 * screenY / 36, paint);
            paint.setColor(Color.parseColor("#BDB76B"));
            canvas.drawRect(0, 34 * screenY / 36, screenX, screenY, paint);

            //Draws the text information at top of screen(name, diff, score, etc..)
            paint.setColor(Color.parseColor("#BDB76B"));
            paint.setTextSize(screenY / 36);
            canvas.drawText("Name: " + name, 0, screenY / 36, paint);
            paint.setTextSize(screenY / 36);
            canvas.drawText("Difficulty: " + difficulty, screenX / 2, screenY / 36, paint);
            paint.setTextSize(screenY / 36);
            canvas.drawText("Life: " + life, 0, 2 * screenY / 36, paint);
            paint.setTextSize(screenY / 36);
            canvas.drawText("Score: " + score, screenX / 2, 2 * screenY / 36, paint);
            //Draws all the vehicles in the vehicle list
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getVehicle() != null) {
                    canvas.drawBitmap(vehicle.getVehicle(), vehicle.getX(), vehicle.getY(), paint);
                }
            }
            //Draws the frog
            canvas.drawBitmap(frog.getFrog(), frog.getX(), frog.getY(), paint);
            //If game is over, does something, not yet implemented
            if (isGameOver) {
                isPlaying = false;
                getHolder().unlockCanvasAndPost(canvas);
                //saveIfHighScore();
                waitBeforeExiting();
                return;
            }
            getHolder().unlockCanvasAndPost(canvas);
        }

    }

    //Waits a select time, then goes to main screen
    private void waitBeforeExiting() {
        try {
            Thread.sleep(3000);
            activity.startActivity(new Intent(activity, Welcome.class));
            activity.finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Sets time between 2 frames(fps)
    private void sleep() {
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getScore() {
        return score;
    }
}
