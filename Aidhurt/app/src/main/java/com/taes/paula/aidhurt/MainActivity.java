package com.taes.paula.aidhurt;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    Intent mServiceIntent;
    private SensorService mSensorService;
    Context ctx;
    public Context getCtx() {
        return ctx;
    }

    ImageButton imageButton;
    GPS gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, Accelerometer.class);
        //Start Service
        startService(intent);
        ctx = this;
        //setContentView(R.layout.activity_main);
        mSensorService = new SensorService(getCtx());
        mServiceIntent = new Intent(getCtx(), mSensorService.getClass());
        if (!isMyServiceRunning(mSensorService.getClass())) {
            startService(mServiceIntent);
        }

        if(SaveSharedPreference.getUserName(MainActivity.this).length() == 0) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }

        gps = new GPS(this);
        addListenerOnButton();
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("isMyServiceRunning?", true+"");
                return true;
            }
        }
        Log.i ("isMyServiceRunning?", false+"");
        return false;
    }


    @Override
    protected void onDestroy() {
        stopService(mServiceIntent);
        Log.i("MAINACT", "onDestroy!");
        super.onDestroy();
    }


    public void clickContrarreloj(View v){
        Intent intent = new Intent(MainActivity.this, Juego2.class);
        intent.putExtra("id", true);
        startActivity(intent);//

    }

    public void addListenerOnButton(){
        imageButton = (ImageButton) findViewById(R.id.imageButton1);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Juego2.class);
                startActivity(intent);
              //  Toast.makeText(MainActivity.this,"Boton click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goAjustes(View view) {
        Intent intent = new Intent(MainActivity.this, Ajustes.class);
        startActivity(intent);
    }

    public void click (View v) {
        new HttpAsyncTask().execute("");
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return peticionesAPI.avisoVictima(1,MainActivity.this,gps);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Peticion Realizada con Éxito", Toast.LENGTH_LONG).show();
        }
    }

}
