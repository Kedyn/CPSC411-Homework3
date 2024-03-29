package com.example.homeworktwo.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class PersistentObject {
    public abstract void createTable(SQLiteDatabase db);
    public abstract void initFrom(SQLiteDatabase db, Cursor cursor);
    public abstract void insert(SQLiteDatabase db);
    public abstract void update(SQLiteDatabase db);
}
