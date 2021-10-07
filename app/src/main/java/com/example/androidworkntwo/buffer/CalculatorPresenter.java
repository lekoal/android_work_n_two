package com.example.androidworkntwo.buffer;

import com.example.androidworkntwo.domain.Calculator;
import com.example.androidworkntwo.domain.Operation;
import com.example.androidworkntwo.ui.CalculatorView;

public class CalculatorPresenter {
    private final int BASE = 10;

    private final CalculatorView view;
    private final Calculator calculator;

    private Double argOne = 0.0;
    private Double argTwo = null;

    private Operation previousOperation;

    private boolean isDotPressed;

    private boolean isOperationEnded;

    private int divider;


    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed(int digit) {

        if (argTwo == null) {

            if (isOperationEnded) {
                argOne = 0.0;
                isOperationEnded = false;
            }

            if (isDotPressed) {
                argOne = argOne + digit / (double) divider;
                divider *= BASE;
            } else {
                argOne = argOne * BASE + digit;
            }
            displayResult(argOne);
        } else {
            if (isDotPressed) {
                argTwo = argTwo + digit / (double) divider;
                divider *= BASE;
            } else {
                argTwo = argTwo * BASE + digit;
            }
            displayResult(argTwo);
        }
    }

    public void onOperationPressed(Operation operation) {
        if (previousOperation != null) {
            double result = calculator.performOperation(argOne, argTwo, previousOperation);
            displayResult(result);
            argOne = result;
        }
        previousOperation = operation;
        argTwo = 0.0;
        isDotPressed = false;
    }

    public void onEquallyPressed(Operation operation) {
        if (previousOperation != null) {
            double result = calculator.performOperation(argOne, argTwo, previousOperation);
            displayResult(result);
            argOne = result;
        }
        argTwo = null;
        previousOperation = null;
        isDotPressed = false;
        isOperationEnded = true;
    }

    public void onClearPressed(Operation operation) {
        previousOperation = null;
        argOne = 0.0;
        argTwo = null;
        displayResult(0.0);
    }

    public void onSquareRootPressed(Operation operation) {
        if (argTwo != null) {
            argTwo = Math.sqrt(argTwo);
            displayResult(argTwo);
        } else {
            argOne = Math.sqrt(argOne);
            displayResult(argOne);
        }
    }

    public void onNegatePressed(Operation operation) {
        if (argTwo != null) {
            argTwo = -argTwo;
            displayResult(argTwo);
        } else {
            argOne = -argOne;
            displayResult(argOne);
        }
    }

    public void onDotPressed() {
        if (!isDotPressed) {
            isDotPressed = true;
            divider = BASE;
        }
    }

    private void displayResult(double arg) {
        long longValue = (long) arg;
        if (longValue == arg) {
            view.showResult(String.valueOf(longValue));
        } else {
            view.showResult(String.valueOf(arg));
        }
    }

    public Double getArgOne() {
        return argOne;
    }

    public Double getArgTwo() {
        return argTwo;
    }

    public Operation getPreviousOperation() {
        return previousOperation;
    }

    public void setArgOne(Double argOne) {
        this.argOne = argOne;
    }

    public void setArgTwo(Double argTwo) {
        this.argTwo = argTwo;
    }

    public void setPreviousOperation(Operation previousOperation) {
        this.previousOperation = previousOperation;
    }
}
