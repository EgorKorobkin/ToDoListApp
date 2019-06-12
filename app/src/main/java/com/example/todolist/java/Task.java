package com.example.todolist.java;

import static com.example.todolist.db.TaskBase.itemsAllTask;

public abstract class Task {
    private int Color;
    private String text ;
    public boolean taskDone;

    public abstract String getText();

    public void addTask(Task task){
        itemsAllTask.add(task);
    }
    public abstract int getColor();
    public abstract boolean getTaskDone();
    public int getTaskDoneInt(){
        return -1;
    }
    public abstract int getNum();
    public abstract void setTaskDone();
    public abstract void setTaskUse();
}
