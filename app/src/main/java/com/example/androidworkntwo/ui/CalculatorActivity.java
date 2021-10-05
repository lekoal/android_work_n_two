package com.example.androidworkntwo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidworkntwo.R;
import com.example.androidworkntwo.buffer.CalculatorPresenter;
import com.example.androidworkntwo.domain.CalculatorImp;
import com.example.androidworkntwo.domain.Operation;

import java.util.HashMap;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView txtResult;

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator);

        presenter = new CalculatorPresenter(this, new CalculatorImp());

        txtResult = findViewById(R.id.txt_result);

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_0, 0);
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDigitPressed(digits.get(v.getId()));
            }
        };

        findViewById(R.id.key_1).setOnClickListener(digitClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitClickListener);
        findViewById(R.id.key_0).setOnClickListener(digitClickListener);

        Map<Integer, Operation> operators = new HashMap<>();
        operators.put(R.id.key_plus, Operation.ADD);
        operators.put(R.id.key_minus, Operation.SUB);
        operators.put(R.id.key_mult, Operation.MUL);
        operators.put(R.id.key_div, Operation.DIV);

        View.OnClickListener operationClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOperationPressed(operators.get(v.getId()));
            }
        };

        findViewById(R.id.key_plus).setOnClickListener(operationClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operationClickListener);
        findViewById(R.id.key_mult).setOnClickListener(operationClickListener);
        findViewById(R.id.key_div).setOnClickListener(operationClickListener);

        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDotPressed();
            }
        });

    }

    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }
}
