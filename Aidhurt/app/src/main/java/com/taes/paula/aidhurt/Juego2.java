package com.taes.paula.aidhurt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Juego2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego2);

        crearTablero();
    }



    public void crearTablero(){
        TextView t = (TextView) findViewById(R.id.editTextN4);
        t.setText("5");

        /*añadir estas lineas cuando se cree un plain text
        android:clickable="false"
        android:cursorVisible="false"
        android:focusable="false"
        android:focusableInTouchMode="false"
        android:background="@null"
        */
    }


    public void clickNew_1_1(View v){

    }

    public void clickNew_1_2(View v){

    }

    public void clickNew_1_3(View v){

    }

    public void clickNew_1_4(View v){

    }

    public void clickNew_1_5(View v){

    }

    public void clickNew_1_6(View v){

    }



    public void clickNew_2_1(View v){

    }

    public void clickNew_2_2(View v){

    }

    public void clickNew_2_3(View v){

    }

    public void clickNew_2_4(View v){

    }

    public void clickNew_2_5(View v){

    }

    public void clickNew_2_6(View v){

    }


    public void clickNew_3_1(View v){

    }

    public void clickNew_3_2(View v){

    }

    public void clickNew_3_3(View v){

    }

    public void clickNew_3_4(View v){

    }

    public void clickNew_3_5(View v){

    }

    public void clickNew_3_6(View v){

    }



    public void clickNew_4_1(View v){

    }

    public void clickNew_4_2(View v){

    }

    public void clickNew_4_3(View v){

    }

    public void clickNew_4_4(View v){

    }

    public void clickNew_4_5(View v){

    }

    public void clickNew_4_6(View v){

    }



    public void clickNew_5_1(View v){

    }

    public void clickNew_5_2(View v){

    }

    public void clickNew_5_3(View v){

    }

    public void clickNew_5_4(View v){

    }

    public void clickNew_5_5(View v){

    }

    public void clickNew_5_6(View v){

    }


    public void clickNew_6_1(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView39);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }

    }

    public void clickNew_6_2(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView39);
        if(i != null){
            i.setVisibility(View.INVISIBLE);
        }
    }

    public void clickNew_6_3(View v){

    }

    public void clickNew_6_4(View v){

    }

    public void clickNew_6_5(View v){

    }

    public void clickNew_6_6(View v){

    }



}
