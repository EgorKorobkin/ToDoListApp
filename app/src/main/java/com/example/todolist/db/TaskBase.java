package com.example.todolist.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.todolist.java.Task;
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
    public void setCheckBoxInSql(Task task){
        ContentValues contentValues = new ContentValues();
        contentValues.put("VALUE_BOOLEAN",1);
        //System.out.println("#######################   Метод setCheckBoxInSql     #############################");
        database.update("TASK",contentValues,"TASK_TEXT = ?",new String[] {task.getText()});
    }
    public void setOffCheckBoxInSql(Task task){
        ContentValues contentValues = new ContentValues();
        contentValues.put("VALUE_BOOLEAN",0);
        //System.out.println("#######################   Метод setOffCheckBoxInSql     #############################");
        database.update("TASK",contentValues,"TASK_TEXT = ?",new String[] {task.getText()});
    }
    public void removeTaskInSql(Task task){
        database.delete("TASK","TASK_TEXT = ?",new String[] {task.getText()});
    }


    private static ContentValues getContentValues(Task task){
        ContentValues taskValues = new ContentValues();
        taskValues.put("TASK_TEXT",task.getText());
        taskValues.put("TASK_TYPE",task.getNum());
        taskValues.put("VALUE_BOOLEAN",task.getTaskDoneInt());

        return taskValues;
    }


}
