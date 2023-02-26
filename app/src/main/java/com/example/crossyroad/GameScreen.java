package com.example.crossyroad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity implements View.OnClickListener {

    private ImageView sprite;
    private int one_move = 50;
    private TextView life;
    private TextView difficulty;
    private TextView player_name;
    private TextView score;
    private FrameLayout game_screen;

    //slide use
    RelativeLayout relativeLayout;
    SwipeListener swipeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Bundle extras = getIntent().getExtras();

        game_screen = findViewById(R.id.game_window);

        sprite = findViewById(R.id.sprite);
        life = findViewById(R.id.life);
        difficulty = findViewById(R.id.difficulty);
        player_name = findViewById(R.id.name);
        score = findViewById(R.id.score);

        score.setText("Score: 0");
        player_name.setText("Player: " + extras.getString("name"));
        difficulty.setText("Difficulty: " + extras.getString("difficulty"));

        if (extras.getString("difficulty").equals("Easy")) {
            life.setText("Life: 5");
        } else if (extras.getString("difficulty").equals("Medium")) {
            life.setText("Life: 4");
        } else if (extras.getString("difficulty").equals("Hard")) {
            life.setText("Life: 3");
        }

        if (extras.getInt("sprite") == 1) {
            sprite.setImageResource(R.drawable.forg);
        } else if (extras.getInt("sprite") == 2) {
            sprite.setImageResource(R.drawable.forg2);
        } else if (extras.getInt("sprite") == 3) {
            sprite.setImageResource(R.drawable.forg3);
        }

        findViewById(R.id.right).setOnClickListener(this);
        findViewById(R.id.left).setOnClickListener(this);
        findViewById(R.id.up).setOnClickListener(this);
        findViewById(R.id.down).setOnClickListener(this);

        //swipe use
        relativeLayout = findViewById(R.id.relative_layout);
        swipeListener = new SwipeListener(relativeLayout);

    }

    public void moveRight() {
        sprite.setX(sprite.getX() + one_move);
        if (sprite.getX() > game_screen.getWidth() - sprite.getWidth()) {
            sprite.setX(game_screen.getWidth() - sprite.getWidth());
        }
    }
    public void moveLeft() {
        sprite.setX(sprite.getX() - one_move);
        if (sprite.getX() < 0) {
            sprite.setX(0);
        }
    }
    public void moveUp() {
        sprite.setY(sprite.getY() - one_move);
        if (sprite.getY() < 0) {
            sprite.setY(0);
        }
    }
    public void moveDown() {
        sprite.setY(sprite.getY() + one_move);
        if (sprite.getY() > game_screen.getHeight() - sprite.getHeight()) {
            sprite.setY(game_screen.getHeight() - sprite.getHeight());
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.right:
                moveRight();
                break;
            case R.id.left:
                moveLeft();
                break;
            case R.id.up:
                moveUp();
                break;
            case R.id.down:
                moveDown();
                break;
        }
    }

    private class SwipeListener implements View.OnTouchListener{
        GestureDetector gestureDetector;

        SwipeListener(View view){
            int threshold = 100;
            int velocity_threshold = 100;
            GestureDetector.SimpleOnGestureListener listener = new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onDown(@NonNull MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
                    try {
                        float diffY = e2.getY() - e1.getY();
                        float diffX = e2.getX() - e1.getX();
                        if (Math.abs(diffX) > Math.abs(diffY)) {
                            if (Math.abs(diffX) > threshold && Math.abs(velocityX) > velocity_threshold) {
                                if (diffX > 0) {
                                    moveRight();
                                } else {
                                    moveLeft();
                                }
                            }
                        } else {
                            if (Math.abs(diffY) > threshold && Math.abs(velocityY) > velocity_threshold) {
                                if (diffY > 0) {
                                    moveDown();
                                } else {
                                    moveUp();
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
        public boolean onTouch(View view, MotionEvent motionEvent){
            return gestureDetector.onTouchEvent(motionEvent);
        }

    }
}