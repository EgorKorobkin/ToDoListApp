package com.example.todolist.JavaToDO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.todolist.R;
import android.graphics.Color;

import static com.example.todolist.JavaToDO.Task.itemsAllTask;

public class TaskAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;

    public TaskAdapter(Context context){
        this.context = context;
        //this.taskItems = taskItems;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return itemsAllTask.size();
    }

    @Override
    public Task getItem(int position) {
        return itemsAllTask.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.task_item_xml, null);
        }

        final Task task = itemsAllTask.get(position);

        //тест задачи
        final TextView taskTextView = (TextView) convertView.findViewById(R.id.taskTextView);
        convertView.setBackgroundColor(task.getColor());//красит само поле
        convertView.getBackground().setAlpha(50);
        taskTextView.setText(task.getText());
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.setTaskDone();
                taskTextView.setBackgroundColor(Color.BLACK);
            }
        });
        return convertView;
    }
    public Task getTask(int position) {
        return ((Task) getItem(position));
    }
}
//сортировать массив а затем вызвать метод адаптера setDataInvalidated
