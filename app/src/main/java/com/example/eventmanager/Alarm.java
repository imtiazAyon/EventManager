package com.example.eventmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm!!!!",Toast.LENGTH_LONG).show();
        Log.i("Alarm","ALARM WENT ON FOR"+System.currentTimeMillis());
    }
}
