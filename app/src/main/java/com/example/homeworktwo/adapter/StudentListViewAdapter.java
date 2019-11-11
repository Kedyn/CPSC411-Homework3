package com.example.homeworktwo.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.homeworktwo.R;
import com.example.homeworktwo.StudentDetailActivity;
import com.example.homeworktwo.model.Student;
import com.example.homeworktwo.model.StudentDB;

public class StudentListViewAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return StudentDB.getInstance().getStudents().size();
    }

    @Override
    public Object getItem(int i) {
        return StudentDB.getInstance().getStudents().get(i);
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
            row_view = inflater.inflate(R.layout.student_row, viewGroup, false);
        }
        else {
            row_view = view;
        }

        Student student = StudentDB.getInstance().getStudents().get(i);

        TextView first_name_view = row_view.findViewById(R.id.first_name);
        first_name_view.setText(student.getFirstName());

        TextView last_name_view = row_view.findViewById(R.id.last_name);
        last_name_view.setText(student.getLastName());

        row_view.setTag(i);

        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), StudentDetailActivity.class);
                        intent.putExtra("StudentIndex", ((Integer)view.getTag()).intValue());
                        view.getContext().startActivity(intent);
                    }
                }
        );

        return row_view;
    }
}
