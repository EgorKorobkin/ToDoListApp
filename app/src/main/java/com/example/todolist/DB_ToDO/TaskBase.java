package com.example.todolist.DB_ToDO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.todolist.JavaToDO.Task;

import java.util.ArrayList;

public class TaskBase {
    public static ArrayList<Task> itemsAllTask = new ArrayList<Task>();
    public static ArrayList<Task> itemsTaskEnd = new ArrayList<>();
    public static ArrayList<Task> itemsUseTask = new ArrayList<>();

    public static SQLiteDatabase database;

    public TaskBase(Context context){
        database = new DataBaseTask(context).getReadableDatabase();
    }

    public static void newTask(Task task){
        database.insert("TASK",null,getContentValues(task));
    }

    private static ContentValues getContentValues(Task task){
        ContentValues taskValues = new ContentValues();
        taskValues.put("TASK_TEXT",task.getText());
        taskValues.put("TASK_TYPE",task.getNum());


        return taskValues;
    }

}
