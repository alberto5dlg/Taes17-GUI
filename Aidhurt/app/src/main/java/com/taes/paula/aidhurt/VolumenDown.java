package com.taes.paula.aidhurt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v4.media.session.MediaButtonReceiver;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Paula on 16/03/2017.
 */

public class VolumenDown extends BroadcastReceiver {

    final ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

    private static int countVolume = 0;
    private Timer timer = new Timer();
    private TimerTask timerTask = null;
    private static int getWarning = 0;

    @Override
    public void onReceive(Context context, Intent intent) {

        int volume = (Integer)intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_VALUE");
        Log.i("Tag", "Action : "+ intent.getAction() + " / volume : "+volume);
        countVolume++;
        Log.i("Tag", "countVolume : "+countVolume);
        if(countVolume == 10) {
            Toast.makeText(context, "AVISO VICTIMA", Toast.LENGTH_LONG).show();
            countVolume = 0;
        }

        exec.schedule(new Runnable(){
            @Override
            public void run(){
                if(countVolume > 0) {
                    countVolume = 0;
                    Log.i("Tag", "BORRAMOS!!!!!!!!!!!!!!!");
                }
            }
        }, 5, TimeUnit.SECONDS);


        //Toast.makeText(context, "MAIN ACTIVITY IS BEING CALLED ", Toast.LENGTH_LONG).show();
        /*Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(i);*/

    }
}
