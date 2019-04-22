package com.example.todolist.JavaToDO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.todolist.R;
import android.widget.Toast;
import java.util.ArrayList;
import static com.example.todolist.DB_ToDO.TaskBase.itemsAllTask;
import static com.example.todolist.DB_ToDO.TaskBase.itemsTaskEnd;
import static com.example.todolist.DB_ToDO.TaskBase.itemsUseTask;

public class TaskAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<Task> taskAdapterList;

    public TaskAdapter(Context context){
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        taskAdapterList = itemsAllTask;
    }


    @Override
    public int getCount() {
        return taskAdapterList.size();
    }

    @Override
    public Task getItem(int position) {
        return taskAdapterList.get(position);
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

        final Task task = taskAdapterList.get(position);

        //тест задачи
        final TextView taskTextView = (TextView) convertView.findViewById(R.id.taskTextView);
        convertView.setBackgroundColor(task.getColor());//красит само поле
        convertView.getBackground().setAlpha(50);
        taskTextView.setText(task.getText());
        final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
        checkBox.setChecked(task.getTaskDone());
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.setTaskDone();
                Toast.makeText(context,"Task end!",Toast.LENGTH_SHORT).show();
                itemsTaskEnd.add(task);
            }
        });
        return convertView;
    }
    public Task getTask(int position) {
        return ((Task) getItem(position));
    }

    public void setListEndTask(){
        itemsTaskEnd.clear();//уменьшает количетсво проблем просто очищать колекцию и заново добавлять
        for(Task t : itemsAllTask){
            if(t.getTaskDone()){
                itemsTaskEnd.add(t);
            }
        }
        taskAdapterList = itemsTaskEnd;
        notifyDataSetInvalidated();
    }
    public void setListUseTask(){
        itemsUseTask.clear();
        for(Task t : itemsAllTask){
            if(!t.getTaskDone()){
                itemsUseTask.add(t);
            }
        }
        taskAdapterList = itemsUseTask;
        notifyDataSetInvalidated();
    }
    public void setListAllTask(){
        taskAdapterList = itemsAllTask;
        notifyDataSetInvalidated();
    }
}
