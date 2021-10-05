package com.example.androidworkntwo.domain;

public class CalculatorImp implements Calculator{
    @Override
    public double performOperation(double argOne, double argTwo, Operation operation) {
        switch (operation) {
            case ADD:
                return argOne + argTwo;

            case SUB:
                return argOne - argTwo;

            case MUL:
                return argOne * argTwo;

            case DIV:
                return argOne / argTwo;
        }
        return 0.0;
    }
}
