package com.example.androidworkntwo;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button key_1 = findViewById(R.id.key_1);
        Button key_2 = findViewById(R.id.key_2);
        Button key_3 = findViewById(R.id.key_3);
        Button key_4 = findViewById(R.id.key_4);
        Button key_5 = findViewById(R.id.key_5);
        Button key_6 = findViewById(R.id.key_6);
        Button key_7 = findViewById(R.id.key_7);
        Button key_8 = findViewById(R.id.key_8);
        Button key_9 = findViewById(R.id.key_9);
        Button key_0 = findViewById(R.id.key_0);
        Button key_divide = findViewById(R.id.key_divide);
        Button key_clear = findViewById(R.id.key_clear);
        Button key_multiply = findViewById(R.id.key_multiply);
        Button key_square_root = findViewById(R.id.key_square_root);
        Button key_minus = findViewById(R.id.key_minus);
        Button key_negate = findViewById(R.id.key_negate);
        Button key_dot = findViewById(R.id.key_dot);
        Button key_plus = findViewById(R.id.key_plus);
        Button key_equally = findViewById(R.id.key_equally);

        keys(key_0, "0");
        keys(key_1, "1");
        keys(key_2, "2");
        keys(key_3, "3");
        keys(key_4, "4");
        keys(key_5, "5");
        keys(key_6, "6");
        keys(key_7, "7");
        keys(key_8, "8");
        keys(key_9, "9");
        keys(key_divide, "/");
        keys(key_clear, "clear");
        keys(key_multiply, "*");
        keys(key_square_root, "√");
        keys(key_minus, "-");
        keys(key_negate, "negate");
        keys(key_dot, ".");
        keys(key_plus, "+");
        keys(key_equally, "=");

    }

    private void keys(Button key, String value) {
        TextView display = findViewById(R.id.display);
        key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (value.equals("negate")) {
                    String temp = display.getText().toString();
                    temp = "-" + temp;
                    display.setText(temp);
                    return;
                }
                if (value.equals("clear")) {
                    display.setText("");
                    return;
                }
                if (display.getText() != null && !display.getText().equals("0")) {
                    String temp = display.getText().toString();
                    temp += value;
                    display.setText(temp);
                } else display.setText(value);
            }
        });
    }
}