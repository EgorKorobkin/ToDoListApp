package com.example.todolist.JavaToDO;
import java.util.ArrayList;

public abstract class Task {
    public static ArrayList<Task> itemsAllTask = new ArrayList<Task>();
    private int Color;
    private String text ;
    public boolean taskDone;

    public abstract String getText();

    public void addTask(Task task){
        itemsAllTask.add(task);
    }
    public abstract int getColor();
    public abstract boolean getTaskDone();
    public abstract void setTaskDone();
}
