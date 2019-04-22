package com.example.todolist.JavaToDO;

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
        if (taskDone) {
            taskDone = false;
        } else {
            taskDone = true;
        }
    }

    @Override
    public int getNum() {
        return 2;
    }
}
