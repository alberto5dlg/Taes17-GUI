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

/**
 * Created by Paula on 16/03/2017.
 */

public class VolumenDown extends BroadcastReceiver {

    private static int countVolume = 0;

    @Override
    public void onReceive(Context context, Intent intent) {

        int volume = (Integer)intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_VALUE");
        Log.i("Tag", "Action : "+ intent.getAction() + " / volume : "+volume);
        countVolume++;
        if (countVolume >= 6)
        {
            countVolume=0;
            Toast.makeText(context, "MAIN ACTIVITY IS BEING CALLED ", Toast.LENGTH_LONG).show();
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(i);
        }

    }
}
