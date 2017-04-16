package com.taes.paula.aidhurt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Paula on 06/04/2017.
 */

public class WarningPower extends BroadcastReceiver {

    final ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

    private static int countPower = 0;
    private Timer timer = new Timer();
    private TimerTask timerTask = null;

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.v("onReceive", "Power button is pressed.");

        Toast.makeText(context, "power button clicked", Toast.LENGTH_LONG)
                .show();

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF))
        {
            countPower++;
        }
        else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON))
        {

        }

        if(countPower==2)
        {
            Toast.makeText(context, "AVISO VICTIMA", Toast.LENGTH_LONG).show();
        }

        exec.schedule(new Runnable(){
            @Override
            public void run(){
                if(countPower > 0) {
                    countPower = 0;
                    Log.i("Tag", "BORRAMOS!!!!!!");
                }
            }
        }, 6, TimeUnit.SECONDS);

    }

}
