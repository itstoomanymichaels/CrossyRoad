package com.example.crossyroad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;

import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.view.GestureDetector;
import android.content.Context;

public class GameScreen extends AppCompatActivity {

    private Bundle extras;

    //slide use
    private GameView gameView;

    private RelativeLayout relativeLayout;
    public Frog frog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Point point = new Point();

        getWindowManager().getDefaultDisplay().getSize(point);

        extras = getIntent().getExtras();

        String name = extras.getString("name");
        String difficulty = extras.getString("difficulty");
        int life = setLifeByDifficulty(
                extras.getString("difficulty"));
        int sprite = extras.getInt("sprite");
        frog = new Frog( 0, 0, getResources(), sprite);
        gameView = new GameView(this, point.x, point.y, name, difficulty, life, frog);
        gameView.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeTop() {
                frog.moveUp();
            }
            public void onSwipeRight() {
                frog.moveRight();
            }
            public void onSwipeLeft() {
                frog.moveLeft();
            }
            public void onSwipeBottom() {
                frog.moveDown();
            }
        });

        setContentView(gameView);
    }

    public int setLifeByDifficulty(String difficulty) {
        if (difficulty.equals("Easy")) {
            return 5;
        } else if (difficulty.equals("Medium")) {
            return 4;
        } else if (difficulty.equals("Hard")) {
            return 3;
        } else {
            return -1;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }

}