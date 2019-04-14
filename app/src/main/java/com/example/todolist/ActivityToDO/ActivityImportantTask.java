package com.example.todolist.ActivityToDO;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.example.todolist.JavaToDO.ImportantTask;
import com.example.todolist.JavaToDO.Task;
import com.example.todolist.R;
import static com.example.todolist.JavaToDO.Task.itemsAllTask;

public class ActivityImportantTask extends AppCompatActivity {
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task__add_);

        Toolbar taskToolbar = findViewById(R.id.add_task_toolbar);
        setSupportActionBar(taskToolbar);

        edit =  (EditText) findViewById(R.id.edit_text);
        edit.setTextColor(Color.parseColor("#006400"));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){ // menu
        getMenuInflater().inflate(R.menu.menu_add_task,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //остановились здесь

//        EditText edit =  (EditText) findViewById(R.id.edit_text);
//        edit.setTextColor(Color.parseColor("#006400"));
        String taskText = (String) edit.getText().toString();

        switch (item.getItemId()){
            case R.id.button_addTask:
                Task task = new ImportantTask(taskText);
                itemsAllTask.add(task);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
// создатию задачу и пиннаю в классы
//активность по добавлению сделать одну
//через extra передать что написать в толбаре
//получить текст из плюсика и передать в классы
