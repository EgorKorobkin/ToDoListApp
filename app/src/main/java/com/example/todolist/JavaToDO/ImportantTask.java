package com.example.todolist.JavaToDO;

import android.graphics.Color;

public class ImportantTask extends Task {
    private String text;
    private boolean taskDone;
    private int color = Color.RED;

    public ImportantTask(String text){
        this.text = text;
        taskDone = false; //задача не сделанная
    }

    public String getText() {
        return text;
    }

    @Override
    public int getColor(){
        return color;
    }

    @Override
    public boolean getTaskDone() {
        return taskDone;
    }

    @Override
    public int getTaskDoneInt() {
        if(taskDone) return 1; else return 0;
    }

    @Override
    public void setTaskDone(){
        if (taskDone) {
             taskDone = false;
        } else {
            taskDone = true;
        }
    }

    @Override
    public int getNum() {
        return 0;
    }
}
