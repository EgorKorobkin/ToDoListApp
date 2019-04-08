package com.example.todolist.JavaToDO;

import java.util.ArrayList;

import static android.graphics.Color.BLACK;

public abstract class Task {
    public static ArrayList<Task> itemsTask = new ArrayList<Task>();
//    public Task(){
//        ImportantTask importantTask = new ImportantTask("new Task");
//        itemsTask.add(importantTask);
//    }
    public String text ;

    public abstract String getText();

    public void addTask(Task task){
        itemsTask.add(task);
    }
    public abstract int getColor();
}
