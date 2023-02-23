package com.example.crossyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Bundle extras = getIntent().getExtras();
        ImageView sprite = findViewById(R.id.player_sprite);
        TextView life = findViewById(R.id.life);
        TextView difficulty = findViewById(R.id.difficulty);
        TextView player = findViewById(R.id.name);
        TextView score = findViewById(R.id.score);
        score.setText("Score: 0");
        player.setText("Player: " + extras.getString("name"));
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

    }
}