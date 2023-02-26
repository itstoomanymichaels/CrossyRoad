package com.example.crossyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
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
                validName(name.getText().toString());
                if (name.getText().length() == 0) { // check if no name entered
                    error.setText("Need to enter name first!");
                    error.setVisibility(View.VISIBLE);
                } else if (difficulty.getCheckedRadioButtonId() == -1) { // no difficulty selected
                    error.setText("Difficulty must be selected!");
                    error.setVisibility(View.VISIBLE);
                } else if (sprites.getCheckedRadioButtonId() == -1) { // no sprite selected
                    error.setText("Character must be selected!");
                    error.setVisibility(View.VISIBLE);
                } else { // launch GameScreen
                    //makes parts to grab from ConfigScreen to GameScreen
                    Intent intent = new Intent(ConfigScreen.this, GameScreen.class);
                    intent.putExtra("name", name.getText().toString());
                    String diff = ((RadioButton) findViewById(difficulty.getCheckedRadioButtonId()))
                            .getText().toString();
                    intent.putExtra("difficulty", diff);
                    int selectedSprite = 0;
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
    public boolean validName(String newName) {
        if (newName.length() != 0) {
            return true;
        }
        return false;
    }
}
