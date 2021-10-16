package com.example.androidworkntwo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;

import com.example.androidworkntwo.R;

public class ThemeSelectionActivity extends AppCompatActivity {

    private final String ACCESS_MESSAGE = "ACCESS_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_selection);

        ImageView imageThemeLeft = findViewById(R.id.image_dark_light_theme);
        ImageView imageThemeRight = findViewById(R.id.image_black_theme);

        imageThemeLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(1);
            }
        });

        imageThemeRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(2);
            }
        });
    }

    private void sendMessage(int message) {
        Intent data = new Intent();
        data.putExtra(ACCESS_MESSAGE, message);
        setResult(RESULT_OK, data);
        finish();
    }
}