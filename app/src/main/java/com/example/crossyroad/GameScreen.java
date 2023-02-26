package com.example.crossyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class GameScreen extends AppCompatActivity implements View.OnClickListener {

    private ImageView sprite;
    private int oneMove = 50;
    private TextView life;
    private TextView difficulty;
    private TextView playerName;
    private TextView score;
    private FrameLayout gameScreen;

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

    }

    public void moveRight() {
        sprite.setX(sprite.getX() + oneMove);
        if (sprite.getX() > gameScreen.getWidth() - sprite.getWidth()) {
            sprite.setX(gameScreen.getWidth() - sprite.getWidth());
        }
    }
    public void moveLeft() {
        sprite.setX(sprite.getX() - oneMove);
        if (sprite.getX() < 0) {
            sprite.setX(0);
        }
    }
    public void moveUp() {
        sprite.setY(sprite.getY() - oneMove);
        if (sprite.getY() < 0) {
            sprite.setY(0);
        }
    }
    public void moveDown() {
        sprite.setY(sprite.getY() + oneMove);
        if (sprite.getY() > gameScreen.getHeight() - sprite.getHeight()) {
            sprite.setY(gameScreen.getHeight() - sprite.getHeight());
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
        default:
            break;
        }


    }
}