package com.example.todolist.ActivityToDO;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.todolist.DB_ToDO.DataBaseTask;
import com.example.todolist.DB_ToDO.TaskBase;
import com.example.todolist.JavaToDO.ImportantTask;
import com.example.todolist.JavaToDO.NotImportantTask;
import com.example.todolist.JavaToDO.OtherTask;
import com.example.todolist.JavaToDO.Task;
import com.example.todolist.JavaToDO.TaskAdapter;
import com.example.todolist.R;

import static com.example.todolist.DB_ToDO.TaskBase.itemsAllTask;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    TaskAdapter taskAdapter;
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            TaskBase taskBase = new TaskBase(this);

            sqLiteOpenHelper = new DataBaseTask(this);
            db = sqLiteOpenHelper.getReadableDatabase();

            cursor = db.query("TASK",new String[]{"TASK_TEXT","TASK_TYPE","VALUE_BOOLEAN"},
                    null,null,null,null,null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                String taskText = cursor.getString(0);
                int typeTask = cursor.getInt(1);
                int boolTask = cursor.getInt(2);

                Task task;

                if(typeTask==0) {
                    task = new ImportantTask(taskText);
                } else if (typeTask == 1){
                    task = new NotImportantTask(taskText);
                } else {
                    task = new OtherTask(taskText);
                }

                if (boolTask == 0) {
                    task.taskDone = false;
                } else task.taskDone = true;

                itemsAllTask.add(task);
                cursor.moveToNext();
            }

        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this,"data base unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        taskAdapter = new TaskAdapter(this);
        ListView lvMain = (ListView) findViewById(R.id.lvItems); //находим список
        lvMain.setAdapter(taskAdapter); //присваиваем адаптер списку
        DataBaseTask dataBaseTask = new DataBaseTask(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){ //метод активити который задает три точки
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.allTask :
                taskAdapter.setListAllTask();
                return true;
            case R.id.useTask :
                taskAdapter.setListUseTask();
                return true;
            case R.id.endTask :
                taskAdapter.setListEndTask();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one:
                Toast.makeText(getApplicationContext(),
                        "Important task",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ActivityImportantTask.class);
                this.startActivity(intent);
                return true;
            case R.id.two:
                Toast.makeText(getApplicationContext(),
                        "Not important task",
                        Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, ActivityNotImportantTask.class);
                this.startActivity(intent2);
                return true;
            case R.id.three:
                Toast.makeText(getApplicationContext(),
                        "Other task",
                        Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, ActivityOtherTask.class);
                this.startActivity(intent3);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
