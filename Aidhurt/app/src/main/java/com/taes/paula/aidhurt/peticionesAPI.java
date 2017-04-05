package com.taes.paula.aidhurt;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

/**
 * Created by Alberto on 4/4/17.
 */

public class peticionesAPI {


    public static void avisoVictima(int severidad, Context ctx, GPS gps){
        
        String id = SaveSharedPreference.getUserName(ctx);
        double latitud = gps.getLatitud();
        double longitud = gps.getLongitud();


    }


}



