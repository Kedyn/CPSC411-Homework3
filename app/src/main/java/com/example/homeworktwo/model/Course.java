package com.example.homeworktwo.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Course extends PersistentObject {
    private String c_id;
    private String c_grade;
    private int c_owner;

    public Course(String id, String grade, int owner) {
        c_id = id;
        c_grade = grade;
        c_owner = owner;
    }

    public Course() {}

    public String getID() {
        return c_id;
    }

    public void setID(String id) {
        c_id = id;
    }

    public String getGrade() {
        return c_grade;
    }

    public void setGrade(String grade) {
        c_grade = grade;
    }

    public int getOwner() {
        return c_owner;
    }

    public void setOwner(int owner) {
        c_owner = owner;
    }

    @Override
    public void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Course (ID Text, Grade Text, Owner INTEGER)");
    }

    @Override
    public void initFrom(SQLiteDatabase db, Cursor cursor) {
        c_id = cursor.getString(cursor.getColumnIndex("ID"));
        c_grade = cursor.getString(cursor.getColumnIndex("Grade"));
        c_owner = cursor.getInt(cursor.getColumnIndex("Owner"));
    }

    @Override
    public void insert(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put("ID", c_id);
        values.put("Grade", c_grade);
        values.put("Owner", c_owner);

        db.insert("Course", null, values);
    }

    @Override
    public void update(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put("ID", c_id);
        values.put("Grade", c_grade);
        values.put("Owner", c_owner);

        if (db.update("Course", values, "ID=? and Owner=?", new String[]{c_id, Integer.valueOf(c_owner).toString()}) < 1) {
            insert(db);
        }
    }
}
