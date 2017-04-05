package com.taes.paula.aidhurt;

/**
 * Created by Alberto on 4/4/17.
 */

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import static java.lang.Thread.sleep;

/**
 * Created by Jose on 18/10/2016.
 */
public class GPS extends Service implements LocationListener {

    /**
     * Referencia estatica al servicio de localizacion
     */
    private static LocationManager locationManager;

    /**
     * Referencia estatica al este servicio
     */
    private static GPS mainGps;

    /**
     * Contexto de la aplicacion
     */
    Context context;

    /**
     * Tiempo en el que se adquirio una respuesta de GPS por ultima vez
     */
    private static long lastResponse = 0;

    /**
     * Tiempo maximo entre respuestas de GPS antes de considerar la señal como perdida
     */
    private static long maxWait = 5000;

    /**
     * Almacena la ultima Longitud conocida
     */
    private double longitud = 0;

    /**
     * Almacena la ultima Latitud conocida
     */
    private double latitud = 0;

    /**
     * Flag que indica si el servicio esta o no disponible
     */
    private boolean conected = false;


    /**
     * Retorna la ultima Longitud conocida
     * @return Ultima longitud conocida
     */
    public static double getLongitud(){
        if (mainGps != null)
            return mainGps.longitud;
        else
            return 0;
    }

    /**
     * Retorna la ultima latitud conocidad
     * @return ultima latitud conocida
     */
    public static double getLatitud(){
        if (mainGps != null)
            return mainGps.latitud;
        else
            return 0;
    }

    /**
     * Retorna un booleano indicando si el servicio de GPS esta disponible
     * @return disponibilidad del servicio de GPS
     */
    public static boolean isEnabled(){

        if (locationManager == null) return false;
        else

            return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                    &&
                    !(System.currentTimeMillis() > lastResponse + maxWait);
    }


    //public GPS gps;

    /**
     * Constructor del servicio de GPS
     * @param context_ Contexto de la aplicacion
     */
    public GPS(Context context_) {
        super();
        mainGps = this;
        context = context_;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ){
            if (!conected && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                //Permiso concedido para consultar el GPS
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,10,this);
                conected = true;
            }else{
                //Error de permiso de acceso al GPS
                if (conected && !locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                    conected = false;
                }
            }
        }else{
            //Error conectando con el servicio de localizacion
            conected = false;
        }
    }

    /**
     * Imprime en consola la ultima posicion conocida
     */
    public void print(){
        System.out.println("Longitud: "+ longitud);
        System.out.println("Latitud: "+latitud);
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null){
            longitud = location.getLongitude();
            latitud= location.getLatitude();
            lastResponse = System.currentTimeMillis();
            print();
        }else{
            //Localizacion nula, se dispara el evento pero no hay señal del GPS
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        // System.out.println("GPS estatus "+ i + ":"+ s);
    }

    @Override
    public void onProviderEnabled(String s) {
        //Conectado al proveedor de servicios del GPS
    }

    @Override
    public void onProviderDisabled(String s) {
        //Desconectado del proveedor de servicios de GPS
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}