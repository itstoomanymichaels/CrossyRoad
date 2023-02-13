package com.example.crossyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ConfigScreen extends AppCompatActivity {
    private RadioGroup difficulty;
    private RadioGroup sprites;
    private Button start;
    private EditText name;
    private TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configscreen);
        difficulty = (RadioGroup) findViewById(R.id.difficulty); // identify difficulty RadioGroup
        start = findViewById(R.id.start); // identify start button
        name = findViewById(R.id.name); // identify name text field
        error = findViewById(R.id.error); // identify error message
        sprites = findViewById(R.id.sprites); // identify sprite RadioGroup

        start.setOnClickListener(new View.OnClickListener() { // check if start button is clicked
            @Override
            public void onClick(View v) {
                if (name.getText().length() == 0) { // check if no name entered
                    error.setText("Need to enter name first!");
                    error.setVisibility(View.VISIBLE);
                } else if (difficulty.getCheckedRadioButtonId() == -1) { // no difficulty selected
                    error.setText("Difficulty must be selected!");
                    error.setVisibility(View.VISIBLE);
                } else if (sprites.getCheckedRadioButtonId() == -1) { // no sprite selected
                    error.setText("Character must be selected!");
                    error.setVisibility(View.VISIBLE);
                }
               else { // launch GameScreen
                   //makes parts to grab from ConfigScreen to GameScreen
                    Intent intent = new Intent(ConfigScreen.this, GameScreen.class);
                    intent.putExtra("name", name.getText().toString());
                    int selectedDiff = difficulty.getCheckedRadioButtonId();
                    intent.putExtra("difficulty", selectedDiff);
                    int selectedSprite = sprites.getCheckedRadioButtonId();
                    intent.putExtra("sprite", selectedSprite);
                    startActivity(intent);
                }
            }
        });
    }
}
