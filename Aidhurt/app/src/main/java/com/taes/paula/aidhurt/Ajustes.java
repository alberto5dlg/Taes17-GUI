package com.taes.paula.aidhurt;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Ajustes extends AppCompatActivity {

    TextView usuario;
    TextView puntuacion;
    EditText codigo;
    GPS gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        gps = new GPS(this);
        Random ran = new Random();
        usuario = (TextView) findViewById(R.id.Usuario);
        puntuacion = (TextView)findViewById(R.id.Puntuacion);
        usuario.append(SaveSharedPreference.getUserName(this));
        puntuacion.append(Integer.toString(ran.nextInt(1000)+1));
        codigo = (EditText) findViewById(R.id.codText);
    }

    public void newLevels(View v){
        new HttpAsyncTask().execute(codigo.getText().toString());
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return peticionesAPI.registroVictima(urls[0], Ajustes.this);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Nuevos niveles Activados", Toast.LENGTH_LONG).show();
        }
    }
}
