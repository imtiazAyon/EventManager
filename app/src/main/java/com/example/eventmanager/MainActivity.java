package com.example.eventmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
            createAlarm(calendar);
        }

        public Event(String name,int day, int month,int year, int hour, int min,String note) {

            this.name = name;
            this.note = note;
            Calendar calendar = Calendar.getInstance();
            calendar.set(year+2000,month-1,day,hour,min);
            this.date = calendar.getTime();
            Log.i("DATE",this.date.toString());
            createAlarm(calendar);
        }

        public void createAlarm(Calendar calendar){
            Intent intent = new Intent(MainActivity.this,Alarm.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                    0,intent,0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
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
        if (day>0 && day<32 && month>0 && month<13 && year<100 && year>0 && hour>=0 && hour<25 && min>=0 && min<61) {
            if (note.isEmpty()) {
                Event e = new Event(name, day, month, year, hour, min);
            } else {
                Event e = new Event(name, day, month, year, hour, min, note);
            }
        }
        else {
            Toast.makeText(this, "The valuse of Date and Time have to be valid!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
