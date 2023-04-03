package com.example.crossyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    private TextView score;

    private Button restart;

    private Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        score = findViewById(R.id.high_score);
        restart = (Button) findViewById(R.id.restart);
        quit = findViewById(R.id.quit);

        Bundle extras = getIntent().getExtras();
        int sc = extras.getInt("name");
        String text = "Score: " + sc;
        score.setText(text);

    }

    public void restart(View v) {
        startActivity(new Intent(GameOver.this, ConfigScreen.class));
    }

    public void close(View v) {
        finishAffinity();
    }

    public Button getRestart() {
        return restart;
    }

    public Button getQuit() {
        return quit;
    }

    public TextView getScore() {
        return score;
    }
}