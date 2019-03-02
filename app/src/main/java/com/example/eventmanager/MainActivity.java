package com.example.eventmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public class Event {

        String name;
        String note;
        Date date;

        public Event(String name,int day, int month,int year, int hour, int min) {

            this.name = name;
            Calendar calendar = Calendar.getInstance();
            calendar.set(year+2000,month-1,day,hour,min);
            this.date = calendar.getTime();
            Log.i("DATE",this.date.toString());
        }

        public Event(String name,int day, int month,int year, int hour, int min,String note) {

            this.name = name;
            this.note = note;
            Calendar calendar = Calendar.getInstance();
            calendar.set(year+2000,month-1,day,hour,min);
            this.date = calendar.getTime();
            Log.i("DATE",this.date.toString());
        }

    }

    public void click(View view) {
        EditText eventDate = findViewById(R.id.eventDate);
        EditText eventTime = findViewById(R.id.eventTime);
        EditText eventName = findViewById(R.id.eventName);
        EditText eventNote = findViewById(R.id.eventNote);
        String name =eventName.getText().toString();
        String note =eventNote.getText().toString();
        String date =eventDate.getText().toString();
        String time =eventTime.getText().toString();
        String[] arr = date.split("/");
        int day = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);
        arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        if(note.isEmpty()){
            Event e =new Event(name,day,month,year,hour,min);
        }
        else {
            Event e =new Event(name,day,month,year,hour,min,note);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
