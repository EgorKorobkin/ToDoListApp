package com.example.todolist.java;

import android.graphics.Color;

public class OtherTask extends Task {
    private String text;
    private boolean taskDone;
    private int color = Color.CYAN;

    public OtherTask(String text){
        this.text = text;
        taskDone = false; //задача не сделанная
    }

    public String getText() {
        return text;
    }

    public boolean getTask(){
        return taskDone;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public boolean getTaskDone() {
        return taskDone;
    }
    @Override
    public void setTaskDone() {
        taskDone = true;
    }

    @Override
    public void setTaskUse() {
        taskDone = false;
    }

    @Override
    public int getNum() {
        return 2;
    }
}
