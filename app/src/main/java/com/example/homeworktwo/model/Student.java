package com.example.homeworktwo.model;

import java.util.ArrayList;

public class Student {
    private String s_first_name;
    private String s_last_name;
    private int s_cwid;
    private ArrayList<Course> s_courses;

    public Student(String first_name, String last_name, int cwid) {
        s_first_name = first_name;
        s_last_name = last_name;
        s_cwid = cwid;
    }

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
}