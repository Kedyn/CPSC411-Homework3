package com.example.homeworktwo.utils;

import android.text.TextWatcher;

public abstract class PositionAwareTextWatcher implements TextWatcher {
    private int position;

    public PositionAwareTextWatcher(int position){
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }
}
