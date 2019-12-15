package com.example.homeworktwo.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Student extends PersistentObject {
    private String s_first_name;
    private String s_last_name;
    private int s_cwid;
    private ArrayList<Course> s_courses;

    public Student(String first_name, String last_name, int cwid) {
        s_first_name = first_name;
        s_last_name = last_name;
        s_cwid = cwid;
    }

    public Student() {}

    public String getFirstName() {
        return s_first_name;
    }

    public void setFirstName(String first_name) {
        s_first_name = first_name;
    }

    public String getLastName() {
        return s_last_name;
    }

    public void setLastName(String last_name) {
        s_last_name = last_name;
    }

    public int getCWID() {
        return s_cwid;
    }

    public void setCWID(int cwid) {
        s_cwid = cwid;
    }

    public ArrayList<Course> getCourses() {
        return s_courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        s_courses = courses;
    }

    public void addCourse(Course course) { s_courses.add(course); }

    @Override
    public void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Student (FirstName Text, LastName Text, CWID INTEGER)");
    }

    @Override
    public void initFrom(SQLiteDatabase db, Cursor cursor) {
        s_first_name = cursor.getString(cursor.getColumnIndex("FirstName"));
        s_last_name = cursor.getString(cursor.getColumnIndex("LastName"));
        s_cwid = cursor.getInt(cursor.getColumnIndex("CWID"));

        s_courses = new ArrayList<Course>();

        Cursor courses_cursor = db.query("Course", null, "Owner=?", new String[]{Integer.valueOf(s_cwid).toString()}, null, null, null, null);

        if (courses_cursor.getCount() > 0) {
            while (courses_cursor.moveToNext()) {
                Course course = new Course();

                course.initFrom(db, courses_cursor);

                s_courses.add(course);
            }
        }
    }

    @Override
    public void insert(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put("FirstName", s_first_name);
        values.put("LastName", s_last_name);
        values.put("CWID", s_cwid);

        db.insert("Student", null, values);

        for (int i = 0; i < s_courses.size(); i++) {
            s_courses.get(i).setOwner(s_cwid);
            s_courses.get(i).insert(db);
        }
    }

    @Override
    public void update(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put("FirstName", s_first_name);
        values.put("LastName", s_last_name);
        values.put("CWID", s_cwid);

        db.update("Student", values, "CWID=?", new String[]{new Integer(s_cwid).toString()});

        for (int i = 0; i < s_courses.size(); i++) {
            s_courses.get(i).setOwner(s_cwid);
            s_courses.get(i).update(db);
        }
    }
}