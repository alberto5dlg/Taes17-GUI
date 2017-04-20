package com.taes.paula.aidhurt;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.media.session.MediaSession;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;


import com.google.firebase.iid.FirebaseInstanceId;

import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by Alberto on 4/4/17.
 */

public class peticionesAPI {

    public static String avisoVictima(int severidad, Context ctx, GPS gps) {

        InputStream inputStream = null;
        String result = "";
        String url = "http://apitaes2017.herokuapp.com/avisoVictima";
        int usuario = SaveSharedPreference.getIdUser();

        try {
            HttpClient http = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            String json = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("latitud", Double.toString(gps.getLatitud()));
            jsonObject.accumulate("longitud", Double.toString(gps.getLongitud()));
            jsonObject.accumulate("severidad", severidad);
            jsonObject.accumulate("idUsuario", usuario);

            json = jsonObject.toString();
            StringEntity se = new StringEntity(json);
            httpPost.setEntity(se);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse httpResponse = http.execute(httpPost);
            inputStream = httpResponse.getEntity().getContent();

            if (inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        System.out.println(result);
        return result;
    }

    public static String registroVictima(String codigo, Context ctx) {

        String token = "";
        InputStream inputStream = null;
        String result = "";
        String usuario = SaveSharedPreference.getUserName(ctx);
        String url = "http://apitaes2017.herokuapp.com/victima/" + usuario;

        try {
            HttpClient http = new DefaultHttpClient();
            HttpPut httpPut = new HttpPut(url);
            String json = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("token", FirebaseInstanceId.getInstance().getToken());
            jsonObject.accumulate("codigo", codigo);

            json = jsonObject.toString();
            StringEntity se = new StringEntity(json);
            httpPut.setEntity(se);
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-type", "application/json");
            HttpResponse httpResponse = http.execute(httpPut);
            inputStream = httpResponse.getEntity().getContent();

            if (inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        System.out.println(result);
        return result;

    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }


}



