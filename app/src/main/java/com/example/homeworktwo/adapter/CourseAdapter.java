package com.example.homeworktwo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.homeworktwo.R;
import com.example.homeworktwo.model.Course;

import java.util.ArrayList;

public class CourseAdapter extends ArrayAdapter<Course> {
    private ArrayList<Course> c_courses;

    public CourseAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);

        c_courses = courses;
    }

    @Override
    public int getCount() {
        return c_courses.size();
    }

    @Override
    public Course getItem(int i) {
        return c_courses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.course_row, viewGroup, false);
        }
        else {
            row_view = view;
        }

        Course course = c_courses.get(i);

        EditText course_text = row_view.findViewById(R.id.course_val);
        course_text.setText(course.getID());

        EditText grade_text = row_view.findViewById(R.id.grade_val);
        grade_text.setText(course.getGrade());

        return row_view;
    }
}
