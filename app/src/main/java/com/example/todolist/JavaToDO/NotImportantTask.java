package com.example.todolist.JavaToDO;

import android.graphics.Color;

public class NotImportantTask extends Task {
    private String text;
    private boolean taskDone;

    public NotImportantTask(String text){
        this.text = text;
        taskDone = false; //задача не сделанная
    }

    public String getText() {
        return text;
    }

    public void setTaskDone(boolean taskDone) {
        this.taskDone = taskDone;
    }

    public boolean getTask(){
        return taskDone;
    }

    @Override
    public int getColor() {
        return Color.GREEN;
    }
}
