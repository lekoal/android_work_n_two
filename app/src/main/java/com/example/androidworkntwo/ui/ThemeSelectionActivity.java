package com.example.androidworkntwo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.androidworkntwo.R;

public class ThemeSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_selection);

        ImageView imageThemeLeft = findViewById(R.id.image_dark_light_theme);
        ImageView imageThemeRight = findViewById(R.id.image_black_theme);

        imageThemeLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemeSelectionActivity.this, CalculatorActivity.class);
                intent.putExtra("THEME_ID", 0);
                startActivity(intent);
            }
        });

        imageThemeRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemeSelectionActivity.this, CalculatorActivity.class);
                intent.putExtra("THEME_ID", 1);
                startActivity(intent);
            }
        });
    }
}