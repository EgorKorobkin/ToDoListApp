package com.example.todolist.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.todolist.db.TaskBase;
import com.example.todolist.java.NotImportantTask;
import com.example.todolist.java.Task;
import com.example.todolist.R;
import static com.example.todolist.db.TaskBase.itemsAllTask;

public class ActivityNotImportantTask extends AppCompatActivity {
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task__add_);

        Toolbar taskToolbar = findViewById(R.id.add_task_toolbar);
        setSupportActionBar(taskToolbar);

        edit =  (EditText) findViewById(R.id.edit_text);
        edit.setTextColor(Color.parseColor("#ff0000"));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){ // menu
        getMenuInflater().inflate(R.menu.menu_add_task,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //остановились здесь

        String taskText = (String) edit.getText().toString().toLowerCase();

        switch (item.getItemId()){
            case R.id.button_addTask:
                Task task = new NotImportantTask(taskText);
                itemsAllTask.add(task);
                TaskBase.newTask(task);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
