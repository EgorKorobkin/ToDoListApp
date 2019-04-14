package com.example.todolist.JavaToDO;

import android.graphics.Color;

public class ImportantTask extends Task {
    public String text;
    public boolean taskDone;
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
    public void setTaskDone(){
        taskDone = true;
    }

}
