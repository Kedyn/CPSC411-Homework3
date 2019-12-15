package com.example.homeworktwo.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    private ArrayList<Student> s_students;
    private SQLiteDatabase s_sqlite_database;

    private StudentDB() {}

    public static StudentDB getInstance() {
        return ourInstance;
    }

    public void setContext(Context context) {
        File db_file = context.getDatabasePath("student.db");

        s_sqlite_database = SQLiteDatabase.openOrCreateDatabase(db_file, null);

        new Student().createTable(s_sqlite_database);
        new Course().createTable(s_sqlite_database);
    }

    public ArrayList<Student> getStudents() {
        return s_students;
    }

    public void setStudents(ArrayList<Student> students) {
        s_students = students;
    }

    public SQLiteDatabase getDB() { return s_sqlite_database; };

    public ArrayList<Student> retrieveStudentObjects() {
        s_students = new ArrayList<Student>();

        Cursor cursor = s_sqlite_database.query("Student", null, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Student student = new Student();

                student.initFrom(s_sqlite_database, cursor);

                s_students.add(student);
            }
        }

        return s_students;
    }
}
