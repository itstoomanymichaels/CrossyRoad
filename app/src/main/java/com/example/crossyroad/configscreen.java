package com.example.crossyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class configscreen extends AppCompatActivity {
    RadioGroup difficulty;
    Button start;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configscreen);
        difficulty = (RadioGroup) findViewById(R.id.difficulty); // identify difficulty radiogroup
        start = findViewById(R.id.start); // identify start button
        name = findViewById(R.id.name); // identify name textbox
        difficulty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // check if difficulty is selected
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton difficultyLevel = group.findViewById(checkedId);
            }
         });

        start.setOnClickListener(new View.OnClickListener() { // check if start button is clicked
            @Override
            public void onClick(View v) {
                if(name.getText().equals("")) { // check if no name entered

                }
            }
        });
    }
}