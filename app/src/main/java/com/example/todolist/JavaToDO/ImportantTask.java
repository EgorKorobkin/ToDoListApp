package com.example.todolist.JavaToDO;

import android.graphics.Color;

public class ImportantTask extends Task {
    public String text;
    private boolean taskDone;
    private int color = Color.RED;

    public ImportantTask(String text){
        this.text = text;
        taskDone = false; //задача не сделанная
    }

    public String getText() {
        return text;
    }

    public void setTaskDone(boolean taskDone) {
        this.taskDone = taskDone;
    }

    public boolean getTaskDone(){
        return taskDone;
    }
    @Override
    public int getColor(){
        return color;
    }

}
