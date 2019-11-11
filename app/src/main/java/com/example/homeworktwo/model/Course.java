package com.example.homeworktwo.model;

public class Course {
    private String c_id;
    private String c_grade;

    public Course(String id, String grade) {
        c_id = id;
        c_grade = grade;
    }

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
}
