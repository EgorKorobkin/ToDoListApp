package com.example.todolist.JavaToDO;

public class NotImportantTask extends Task {
    private String text;
    private boolean taskDone;
    private int color = android.graphics.Color.GREEN;

    public NotImportantTask(String text){
        this.text = text;
        taskDone = false; // false задача не сделанная
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
    public void setTaskDone(){
        taskDone = true;
    }
    @Override
    public void setTaskUse() {
        taskDone = false;
    }

    @Override
    public int getNum() {
        return 1;
    }
}
