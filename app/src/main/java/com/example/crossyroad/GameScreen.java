package com.example.crossyroad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Point;
import android.view.WindowManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GameScreen extends AppCompatActivity {

    private Bundle extras;
    private FrameLayout gameScreen;
    private RelativeLayout relativeLayout;
    private SwipeListener swipeListener;

    //slide use
    private GameView gameView;

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

        gameView = new GameView(this, point.x, point.y, name, difficulty, life, sprite);

        setContentView(gameView);

        relativeLayout = findViewById(R.id.relative_layout);
        swipeListener = new SwipeListener(relativeLayout);
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
    private class SwipeListener implements View.OnTouchListener {
        private GestureDetector gestureDetector;

        SwipeListener(View view) {
            int threshold = 100;
            int velocityThreshold = 100;
            GestureDetector.SimpleOnGestureListener listener = new GestureDetector
                    .SimpleOnGestureListener() {
                @Override
                public boolean onDown(@NonNull MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2,
                                       float velocityX, float velocityY) {
                    try {
                        float diffY = e2.getY() - e1.getY();
                        float diffX = e2.getX() - e1.getX();
                        if (Math.abs(diffX) > Math.abs(diffY)) {
                            if (Math.abs(diffX) > threshold && Math.abs(velocityX)
                                    > velocityThreshold) {
                                if (diffX > 0) {
                                    //moveRight();
                                } else {
                                    //moveLeft();
                                }
                            }
                        } else {
                            if (Math.abs(diffY) > threshold && Math.abs(velocityY)
                                    > velocityThreshold) {
                                if (diffY > 0) {
                                    //moveDown();
                                } else {
                                    //moveUp();
                                }
                            }
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    return false;
                }
            };
            gestureDetector = new GestureDetector(listener);
            view.setOnTouchListener(this);
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }

    }

}