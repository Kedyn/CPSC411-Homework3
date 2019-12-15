package com.example.homeworktwo.adapter;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.homeworktwo.R;
import com.example.homeworktwo.model.Course;
import com.example.homeworktwo.utils.PositionAwareTextWatcher;

import java.util.ArrayList;

public class CourseAdapter extends ArrayAdapter<Course> {
    public CourseAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);
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

        Course course = getItem(i);

        EditText course_text = row_view.findViewById(R.id.course_val);
        course_text.setText(course.getID());

        course_text.addTextChangedListener(new PositionAwareTextWatcher(i) {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                getItem(getPosition()).setID(editable.toString());
            }
        });

        EditText grade_text = row_view.findViewById(R.id.grade_val);
        grade_text.setText(course.getGrade());

        grade_text.addTextChangedListener(new PositionAwareTextWatcher(i) {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                getItem(getPosition()).setGrade(editable.toString());
            }
        });

        return row_view;
    }
}
