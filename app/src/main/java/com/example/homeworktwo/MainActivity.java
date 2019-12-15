package com.example.homeworktwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.homeworktwo.adapter.StudentListViewAdapter;
import com.example.homeworktwo.model.StudentDB;

public class MainActivity extends AppCompatActivity {

    protected ListView m_student_list_view;
    protected final String TAG = "Main screen";
    protected StudentListViewAdapter m_student_list_view_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        StudentDB.getInstance().setContext(this);
        StudentDB.getInstance().retrieveStudentObjects();

        m_student_list_view = findViewById(R.id.student_list_view);
        m_student_list_view_adapter = new StudentListViewAdapter();

        m_student_list_view.setAdapter(m_student_list_view_adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_student) {
            Intent intent = new Intent(this, StudentDetailActivity.class);
            intent.putExtra("new", true);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause() called");
        super.onPause();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called");
        m_student_list_view_adapter.notifyDataSetChanged();
        super.onStart();
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
