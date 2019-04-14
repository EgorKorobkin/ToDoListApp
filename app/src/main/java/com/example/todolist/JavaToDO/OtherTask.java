package com.example.todolist.JavaToDO;

import android.graphics.Color;

import java.io.IOException;

public class OtherTask extends Task {
    private String text;
    private boolean taskDone;

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
        return Color.CYAN;
    }

    @Override
    public boolean getTaskDone() {
        return taskDone;
    }
    @Override
    public void setTaskDone() {
        if (taskDone) {
            taskDone = false;
        } else {
            taskDone = true;
        }
    }
}
