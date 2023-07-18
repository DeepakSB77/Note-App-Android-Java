package com.example.noteapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewTasks;
    private Button buttonAddTask;

    private static List<String> tasks;
    private static ArrayAdapter<String> taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        listViewTasks = findViewById(R.id.listViewTasks);
        buttonAddTask = findViewById(R.id.buttonAddTask);

        // Initialize the list of tasks
        tasks = new ArrayList<>();
        tasks.add("Task 1");
        tasks.add("Task 2");

        // Initialize the task adapter
        taskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);

        // Set the adapter for the task list view
        listViewTasks.setAdapter(taskAdapter);

        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the task creation screen
                Intent intent = new Intent(MainActivity.this, TaskCreationActivity.class);
                startActivity(intent);
            }
        });
    }

    public static List<String> getTasks() {
        return tasks;
    }

    public static ArrayAdapter<String> getTaskAdapter() {
        return taskAdapter;
    }
}
