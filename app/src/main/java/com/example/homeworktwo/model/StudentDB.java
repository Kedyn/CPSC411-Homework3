package com.example.homeworktwo.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    private ArrayList<Student> s_students;

    public static StudentDB getInstance() {
        return ourInstance;
    }

    private StudentDB() { createStudentsObjects(); }

    public ArrayList<Student> getStudents() {
        return s_students;
    }

    public void setStudents(ArrayList<Student> students) {
        s_students = students;
    }

    private void createStudentsObjects() {
        s_students = new ArrayList<Student>();

        Student student = new Student("Student", "One",12345678);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("CPSC411", "A+"));
        student.setCourses(courses);
        s_students.add(student);

        student = new Student("Student", "Two",87654321);
        courses = new ArrayList<Course>();
        courses.add(new Course("CPSC411", "A+"));
        student.setCourses(courses);
        s_students.add(student);
    }
}
