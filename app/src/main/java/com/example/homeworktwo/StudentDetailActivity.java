package com.example.homeworktwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.homeworktwo.adapter.CourseAdapter;
import com.example.homeworktwo.model.Course;
import com.example.homeworktwo.model.Student;
import com.example.homeworktwo.model.StudentDB;

import java.util.ArrayList;
import java.util.Locale;

public class StudentDetailActivity extends AppCompatActivity {

    private Menu s_menu;
    private Student s_student;
    private CourseAdapter s_course_list_view_adapter;
    private boolean s_new;
    private boolean s_added;
    private final String TAG = "Student Detail Screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        s_new = getIntent().getBooleanExtra("new", false);
        s_added = false;

        int index = getIntent().getIntExtra("StudentIndex", 0);

        if (!s_new) {
            s_student = StudentDB.getInstance().getStudents().get(index);

            EditText first_name_view = findViewById(R.id.first_name_val);
            EditText last_name_view = findViewById(R.id.last_name_val);
            EditText cwid_view = findViewById(R.id.cwid_val);

            first_name_view.setText(s_student.getFirstName());
            last_name_view.setText(s_student.getLastName());
            cwid_view.setText(String.format(Locale.getDefault(),"%d", s_student.getCWID()));

            first_name_view.setEnabled(false);
            last_name_view.setEnabled(false);
            cwid_view.setEnabled(false);
        }
        else {
            s_student = new Student("", "", 0);
            ArrayList<Course> courses = new ArrayList<>();
            s_student.setCourses(courses);
        }

        ListView course_list_view = findViewById(R.id.courses_list_view);
        s_course_list_view_adapter = new CourseAdapter(this, s_student.getCourses());

        course_list_view.setAdapter(s_course_list_view_adapter);

        Button add_course = findViewById(R.id.add_course);

        add_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Course> courses = s_student.getCourses();

                courses.add(new Course("",""));

                s_course_list_view_adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.student_detail_screen_menu, menu);
        s_menu = menu;
        if (s_new) {
            menu.findItem(R.id.action_edit).setVisible(false);
            menu.findItem(R.id.action_done).setVisible(true);
        }
        else {
            menu.findItem(R.id.action_edit).setVisible(true);
            menu.findItem(R.id.action_done).setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            EditText first_name_view = findViewById(R.id.first_name_val);
            EditText last_name_view = findViewById(R.id.last_name_val);
            EditText cwid_view = findViewById(R.id.cwid_val);

            first_name_view.setEnabled(true);
            last_name_view.setEnabled(true);
            cwid_view.setEnabled(true);

            s_menu.findItem(R.id.action_edit).setVisible(false);
            s_menu.findItem(R.id.action_done).setVisible(true);
        } else if (item.getItemId() == R.id.action_done) {
            EditText first_name_view = findViewById(R.id.first_name_val);
            EditText last_name_view = findViewById(R.id.last_name_val);
            EditText cwid_view = findViewById(R.id.cwid_val);

            s_student.setFirstName(first_name_view.getText().toString());
            s_student.setLastName(last_name_view.getText().toString());

            if (cwid_view.getText().length() > 0) {
                s_student.setCWID(Integer.valueOf(cwid_view.getText().toString()));
            }

            first_name_view.setEnabled(false);
            last_name_view.setEnabled(false);
            cwid_view.setEnabled(false);

            s_menu.findItem(R.id.action_edit).setVisible(true);
            s_menu.findItem(R.id.action_done).setVisible(false);

            if (s_new && !s_added && cwid_view.getText().length() > 0) {
                ArrayList<Student> students = StudentDB.getInstance().getStudents();
                students.add(s_student);

                s_added = true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause() called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume() called");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        super.onDestroy();
    }
}
