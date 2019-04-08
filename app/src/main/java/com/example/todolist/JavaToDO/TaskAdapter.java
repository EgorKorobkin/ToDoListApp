package com.example.todolist.JavaToDO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.todolist.R;

import static com.example.todolist.JavaToDO.Task.itemsTask;

public class TaskAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    //public ArrayList<Task> taskItems;

    public TaskAdapter(Context context){
        this.context = context;
        //this.taskItems = taskItems;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return itemsTask.size();
    }

    @Override
    public Task getItem(int position) {
        return itemsTask.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.task_item_xml, null);
        }

        Task task = itemsTask.get(position);

        //тест задачи
        TextView taskTextView = (TextView) convertView.findViewById(R.id.taskTextView);
        taskTextView.setBackgroundColor(task.getColor());
        taskTextView.getBackground().setAlpha(80);

        taskTextView.setText(task.getText());
        return convertView;

    }
    public Task getTask(int position){
        return ((Task)getItem(position));
    }
}
