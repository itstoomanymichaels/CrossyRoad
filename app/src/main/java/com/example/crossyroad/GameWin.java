package com.example.crossyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameWin extends AppCompatActivity {

    private TextView score;

    private TextView congrats;

    private Button restart;

    private Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);

        score = findViewById(R.id.whigh_score);
        congrats = findViewById(R.id.textView3);
        restart = (Button) findViewById(R.id.wrestart);
        quit = findViewById(R.id.wquit);

        Bundle extras = getIntent().getExtras();
        int sc = extras.getInt("name");
        String text = "Score: " + sc;
        score.setText(text);

    }

    public void restart(View v) {
        startActivity(new Intent(GameWin.this, ConfigScreen.class));
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

    public TextView getCongrats() {
        return congrats;
    }

    public boolean isRestart() {
        if (this.restart != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isQuit() {
        if (this.quit != null) {
            return true;
        } else {
            return false;
        }
    }

}