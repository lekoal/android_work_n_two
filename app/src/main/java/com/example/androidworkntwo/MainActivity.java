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

        Button key1 = findViewById(R.id.key_1);
        Button key2 = findViewById(R.id.key_2);
        Button key3 = findViewById(R.id.key_3);
        Button key4 = findViewById(R.id.key_4);
        Button key5 = findViewById(R.id.key_5);
        Button key6 = findViewById(R.id.key_6);
        Button key7 = findViewById(R.id.key_7);
        Button key8 = findViewById(R.id.key_8);
        Button key9 = findViewById(R.id.key_9);
        Button key0 = findViewById(R.id.key_0);
        Button keyDivide = findViewById(R.id.key_divide);
        Button keyClear = findViewById(R.id.key_clear);
        Button keyMultiply = findViewById(R.id.key_multiply);
        Button keySquareRoot = findViewById(R.id.key_square_root);
        Button keyMinus = findViewById(R.id.key_minus);
        Button keyNegate = findViewById(R.id.key_negate);
        Button keyDot = findViewById(R.id.key_dot);
        Button keyPlus = findViewById(R.id.key_plus);
        Button keyEqually = findViewById(R.id.key_equally);

        keys(key0, "0");
        keys(key1, "1");
        keys(key2, "2");
        keys(key3, "3");
        keys(key4, "4");
        keys(key5, "5");
        keys(key6, "6");
        keys(key7, "7");
        keys(key8, "8");
        keys(key9, "9");
        keys(keyDivide, "/");
        keys(keyClear, "clear");
        keys(keyMultiply, "*");
        keys(keySquareRoot, "√");
        keys(keyMinus, "-");
        keys(keyNegate, "negate");
        keys(keyDot, ".");
        keys(keyPlus, "+");
        keys(keyEqually, "=");

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
                } else {
                    display.setText(value);
                }
            }
        });
    }
}