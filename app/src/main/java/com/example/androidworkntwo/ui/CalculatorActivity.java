package com.example.androidworkntwo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidworkntwo.R;
import com.example.androidworkntwo.buffer.CalculatorPresenter;
import com.example.androidworkntwo.domain.CalculatorImp;
import com.example.androidworkntwo.domain.Operation;

import java.util.HashMap;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView txtResult;

    private CalculatorPresenter presenter;

    private static final String ARGONE = "ARG_ONE";
    private static final String ARGTWO = "ARG_TWO";
    private static final String OPER = "OPERATION";

    Button themeSelection;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        themeSelection = findViewById(R.id.key_theme_selection);

        themeSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorActivity.this, ThemeSelectionActivity.class);
                startActivity(intent);
            }
        });


        presenter = new CalculatorPresenter(this, new CalculatorImp());

        txtResult = findViewById(R.id.display);
        txtResult.setText("0");
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
        operators.put(R.id.key_multiply, Operation.MUL);
        operators.put(R.id.key_divide, Operation.DIV);

        View.OnClickListener operationClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOperationPressed(operators.get(v.getId()));
            }
        };

        View.OnClickListener equallyClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onEquallyPressed(Operation.EQU);
            }
        };

        View.OnClickListener clearClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClearPressed(Operation.CLR);
            }
        };

        View.OnClickListener squareRootClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSquareRootPressed(Operation.SQRT);
            }
        };

        View.OnClickListener negateClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNegatePressed(Operation.NEG);
            }
        };

        findViewById(R.id.key_plus).setOnClickListener(operationClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operationClickListener);
        findViewById(R.id.key_multiply).setOnClickListener(operationClickListener);
        findViewById(R.id.key_divide).setOnClickListener(operationClickListener);

        findViewById(R.id.key_equally).setOnClickListener(equallyClickListener);

        findViewById(R.id.key_clear).setOnClickListener(clearClickListener);

        findViewById(R.id.key_square_root).setOnClickListener(squareRootClickListener);

        findViewById(R.id.key_negate).setOnClickListener(negateClickListener);

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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putDouble(ARGONE, presenter.getArgOne());
        outState.putDouble(ARGTWO, presenter.getArgTwo());
        outState.putSerializable(OPER, presenter.getPreviousOperation());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        presenter.setArgOne(savedInstanceState.getDouble(ARGONE));
        if (savedInstanceState.getDouble(ARGTWO) != 0.0) {
            presenter.setArgTwo(savedInstanceState.getDouble(ARGTWO));
            displayResult(savedInstanceState.getDouble(ARGTWO));
        } else {
            displayResult(savedInstanceState.getDouble(ARGONE));
        }
        if (!(savedInstanceState.getSerializable(OPER).equals(Operation.NULL))) {
            presenter.setPreviousOperation((Operation) savedInstanceState.getSerializable(OPER));
        }
    }

    private void displayResult(double arg) {
        long longValue = (long) arg;
        if (longValue == arg) {
            txtResult.setText(String.valueOf(longValue));
        } else {
            txtResult.setText(String.valueOf(arg));
        }
    }

    private void changeTheme() {
        Intent intent = getIntent();
        int themeId = intent.getIntExtra("THEME", -1);
        switch (themeId) {
            case 1:
                setTheme(R.style.MyDarkLightTheme);
                themeId = 0;
                intent = null;
                recreate();
                break;

            case 2:
                setTheme(R.style.MyBlackTheme);
                themeId = 0;
                intent = null;
                recreate();
                break;

            default:
                break;
        }
    }
}
