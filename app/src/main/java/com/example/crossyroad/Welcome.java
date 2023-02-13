package com.example.crossyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button start = (Button) findViewById(R.id.startButton);

    }


    public void goConfigScreen(View view) {
        Intent configScreen = new Intent(this, ConfigScreen.class);
        startActivity(configScreen);
    }
}
