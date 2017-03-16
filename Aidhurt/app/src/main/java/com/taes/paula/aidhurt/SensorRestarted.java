package com.taes.paula.aidhurt;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.KeyEvent;

import static android.content.Intent.EXTRA_KEY_EVENT;

/**
 * Created by Paula on 16/03/2017.
 */

public class SensorRestarted extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(SensorRestarted.class.getSimpleName(), "Service Stops! Ooooppssss!!!!");
        context.startService(new Intent(context, SensorService.class));
    }

}
