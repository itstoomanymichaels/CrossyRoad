package com.example.crossyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ConfigScreen extends AppCompatActivity {
    private RadioGroup difficulty;
    private RadioGroup sprites;
    private Button start;
    private EditText name;
    private TextView error;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configscreen);
        difficulty = findViewById(R.id.difficulty); // identify difficulty RadioGroup
        start = findViewById(R.id.start); // identify start button
        name = findViewById(R.id.name); // identify name text field
        error = findViewById(R.id.error); // identify error message
        sprites = findViewById(R.id.sprites); // identify sprite RadioGroup

        start.setOnClickListener(new View.OnClickListener() { // check if start button is clicked
            @Override
            public void onClick(View v) {
                validName(name.getText().toString());
                if (!validName(name.getText().toString())) { // check if no name entered
                    error.setText("Need to enter name first!");
                    error.setVisibility(View.VISIBLE);
                } else if (!difficultyIsSelected(difficulty.getCheckedRadioButtonId())) {
                    // no difficulty selected
                    error.setText("Difficulty must be selected!");
                    error.setVisibility(View.VISIBLE);
                } else if (!spriteIsSelected(sprites.getCheckedRadioButtonId())) {
                    // no sprite selected
                    error.setText("Character must be selected!");
                    error.setVisibility(View.VISIBLE);
                } else { // launch GameScreen
                    //makes parts to grab from ConfigScreen to GameScreen
                    error.setVisibility(View.INVISIBLE);
                    intent = new Intent(ConfigScreen.this, GameScreen.class);
                    intent.putExtra("name", name.getText().toString());
                    String diff = ((RadioButton) findViewById(difficulty.getCheckedRadioButtonId()))
                            .getText().toString();
                    intent.putExtra("difficulty", diff);
                    if (((RadioButton) findViewById(R.id.sprite1)).isChecked()) {
                        intent.putExtra("sprite", 1);
                    } else if (((RadioButton) findViewById(R.id.sprite2)).isChecked()) {
                        intent.putExtra("sprite", 2);
                    } else {
                        intent.putExtra("sprite", 3);
                    }
                    startActivity(intent);
                }
            }
        });
    }

    public boolean difficultyIsSelected(int d) {
        return (d != -1);
    }
    public boolean validName(String newName) {
        return (newName.length() != 0);
    }
    public boolean spriteIsSelected(int s) {
        return (s != -1);
    }
    public int selectedSprite() {
        return intent.getIntExtra("sprite", -1);
    }

}
