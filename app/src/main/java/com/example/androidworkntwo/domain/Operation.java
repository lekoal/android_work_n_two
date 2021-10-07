package com.example.androidworkntwo.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public enum Operation implements Parcelable {
    ADD,
    SUB,
    MUL,
    DIV,
    CLR,
    NEG,
    EQU,
    SQRT,
    NULL;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ordinal());
    }

    public static final Creator<Operation> CREATOR = new Creator<Operation>() {
        @Override
        public Operation createFromParcel(Parcel in) {
            return Operation.values()[in.readInt()];
        }

        @Override
        public Operation[] newArray(int size) {
            return new Operation[size];
        }
    };
}
