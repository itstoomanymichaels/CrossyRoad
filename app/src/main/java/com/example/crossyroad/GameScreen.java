package com.example.crossyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Bundle extras = getIntent().getExtras();
        TextView player = findViewById(R.id.textView4);
        player.setText("Player: " + extras.getString("name"));

    }
}