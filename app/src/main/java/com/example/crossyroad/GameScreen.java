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
    private final float oneMove = 50;
    private TextView life;
    private TextView difficulty;
    private TextView playerName;
    private TextView score;
    private FrameLayout gameScreen;

    //slide use
    RelativeLayout relativeLayout;
    SwipeListener swipeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Bundle extras = getIntent().getExtras();

        gameScreen = findViewById(R.id.game_window);
        sprite = findViewById(R.id.sprite);
        life = findViewById(R.id.life);
        difficulty = findViewById(R.id.difficulty);
        playerName = findViewById(R.id.name);
        score = findViewById(R.id.score);

        score.setText("Score: 0");
        playerName.setText("Player: " + extras.getString("name"));
        difficulty.setText("Difficulty: " + extras.getString("difficulty"));

        String difficultyLife = Integer.toString(SetLifeByDifficulty(extras.getString("difficulty")));
        life.setText("Life: " + difficultyLife);

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

    public int SetLifeByDifficulty(String difficulty) {
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
    private void moveRight() {
        sprite.setX(rightPos(sprite.getX()));
        if (sprite.getX() > gameScreen.getWidth() - sprite.getWidth()) {
            sprite.setX(gameScreen.getWidth() - sprite.getWidth());
        }
    }

    private void moveLeft() {
        sprite.setX(leftPos(sprite.getX()));
        if (sprite.getX() < 0) {
            sprite.setX(0);
        }
    }

    private void moveUp() {
        sprite.setY(upPos(sprite.getY()));
        if (sprite.getY() < 0) {
            sprite.setY(0);
        }
    }

    public void moveDown() {
        sprite.setY(downPos(sprite.getY()));
        if (sprite.getY() > gameScreen.getHeight() - sprite.getHeight()) {
            sprite.setY(gameScreen.getHeight() - sprite.getHeight());
        }
    }

    public float upPos(float y) {
        return y - oneMove;
    }

    public float downPos(float y) {
        return y + oneMove;
    }

    public float leftPos(float x) {
        return x - oneMove;
    }

    public float rightPos(float x) {
        return x + oneMove;
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
            default:
                break;
        }
    }

    private class SwipeListener implements View.OnTouchListener {
        GestureDetector gestureDetector;

        SwipeListener(View view) {
            int threshold = 100;
            int velocity_threshold = 100;
            GestureDetector.SimpleOnGestureListener listener = new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onDown(@NonNull MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX,
                        float velocityY) {
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
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }

    }

    public boolean testBounds(int x, int y) {
        if ((y < 0) || (y > gameScreen.getHeight() - sprite.getHeight()) || (x < 0) || (x > gameScreen.getWidth() - sprite.getWidth())) {
            return true;
        } else {
            return false;
        }
    }
}