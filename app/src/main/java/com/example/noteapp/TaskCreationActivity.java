package com.example.noteapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TaskCreationActivity extends AppCompatActivity {

    private EditText editTextTaskName;
    private Button buttonSaveTask;

    private List<String> tasks;
    private ArrayAdapter<String> taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);

        // Initialize UI elements
        editTextTaskName = findViewById(R.id.editTextTaskName);
        buttonSaveTask = findViewById(R.id.buttonSaveTask);

        // Retrieve the list of tasks and the task adapter from MainActivity
        tasks = MainActivity.getTasks();
        taskAdapter = MainActivity.getTaskAdapter();

        buttonSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the task name entered by the user
                String taskName = editTextTaskName.getText().toString();

                // Add the task to the list
                tasks.add(taskName);

                // Notify the adapter about the data change
                taskAdapter.notifyDataSetChanged();

                // Finish the activity and return to MainActivity
                finish();
            }
        });

        // Enable the back button in the ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the back button click event
        if (item.getItemId() == android.R.id.home) {
            finish(); // Close the current activity and return to MainActivity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }}
   
