package com.example.todolist.ActivityToDO;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.todolist.JavaToDO.TaskAdapter;
import com.example.todolist.R;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        taskAdapter = new TaskAdapter(this);
        ListView lvMain = (ListView) findViewById(R.id.lvItems); //находим список
        lvMain.setAdapter(taskAdapter); //присваиваем адаптер списку
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){ //метод активити который задает три точки
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.stats :
                Intent intent = new Intent(this, ActivityStatistics.class);
                this.startActivity(intent);
                return true;
            case R.id.about :
                Intent intent2 = new Intent(this, ActivityAbout.class);
                this.startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one:
                Toast.makeText(getApplicationContext(),
                        "Important task",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ActivityImportantTask.class);
                this.startActivity(intent);
                return true;
            case R.id.two:
                Toast.makeText(getApplicationContext(),
                        "Not important task",
                        Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, ActivityNotImportantTask.class);
                this.startActivity(intent2);
                return true;
            case R.id.three:
                Toast.makeText(getApplicationContext(),
                        "Other task",
                        Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, ActivityOtherTask.class);
                this.startActivity(intent3);
                return true;
            default:
                return false;
        }
    }
}
