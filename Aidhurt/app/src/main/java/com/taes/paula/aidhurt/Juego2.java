package com.taes.paula.aidhurt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class Juego2 extends AppCompatActivity {


    private int nivel =0;

    private int matriz[][] = new int[6][6];
    private boolean matrizDestapadas[][] = new boolean[6][6];

    private int minas =0;
    private int doses =0;
    private int treses =0;

    private int abiertos=0;

    private int puntuacion =0;

    private boolean forzar = false;

    private boolean modoContrarreloj = false;
    private boolean contrarrelojF = false;

    private boolean invisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego2);







        ImageView img;
        String s ="";
        TextView t;
        Bundle b = getIntent().getExtras();
        if(b != null){
            boolean id = b.getBoolean("id");
            if(id){
                modoContrarreloj = true;
            }else{
                img = (ImageView) findViewById(R.id.imageView17);
                img.setVisibility(View.INVISIBLE);
/*
                img = (ImageView) findViewById(R.id.imageView155);
                img.setVisibility(View.INVISIBLE);*/
                t = (TextView) findViewById(R.id.editText54);
                t.setText("");
            }

        }else{
            img = (ImageView) findViewById(R.id.imageView17);
            img.setVisibility(View.INVISIBLE);
/*
            img = (ImageView) findViewById(R.id.imageView155);
            img.setVisibility(View.INVISIBLE);*/
            t = (TextView) findViewById(R.id.editText54);
            t.setText("");
        }






        crearTablero();
        calcularPuntuacion(0);

    }

    public void vaciarMatriz(){
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                matriz[i][j] =0;
                matrizDestapadas[i][j] = false;
            }
        }
    }
    public void cargarNivel(){
        forzar = false;

        segundosC =30;
        minutosC =1;
        decimasC =0;

        if(nivel ==10){
          //  invisible = true;
        }
        switch(nivel){
            case 1: minas = 6;  doses =4; treses = 0; break;
            case 2: minas = 7;  doses =3; treses = 1; break;
            case 3: minas = 8;  doses =3; treses = 2; break;
            case 4: minas = 10; doses =3; treses = 3; break;
            case 5: minas = 11;  doses =1; treses = 4; break;
            case 6: minas = 13;  doses =2; treses = 4; break;
            case 7: minas = 14;  doses =1; treses = 5; break;
            case 8: minas = 16;  doses =2; treses = 6; break;
            case 9: minas = 18;  doses =2; treses = 7; break;
            case 10: minas = 20;  doses =0; treses = 0; break;
            default: minas = 20; doses =0; treses =0; break;
        }
        if(nivel ==3){
            contrarrelojF = true;

            ImageView img;
            String s ="";
            TextView t;

            img = (ImageView) findViewById(R.id.imageView17);
            img.setVisibility(View.VISIBLE);
            t = (TextView) findViewById(R.id.editText54);
            t.setText("");

  /*          img = (ImageView) findViewById(R.id.imageView155);
            img.setVisibility(View.VISIBLE);
*/

            activarContrarreloj();

        }else{
            if(this.modoContrarreloj == false){
                ImageView img;
                String s ="";
                TextView t;

                img = (ImageView) findViewById(R.id.imageView17);
                img.setVisibility(View.INVISIBLE);

              /*  img = (ImageView) findViewById(R.id.imageView155);
                img.setVisibility(View.INVISIBLE);*/
                t = (TextView) findViewById(R.id.editText54);
                t.setText("");
                contrarrelojF = false;
            }

        }
        abiertos = (doses+treses);

        if(invisible){
            doses =0;
            treses =0;
            abiertos =36-minas;
        }
        rellenarTablero();
        quitarMinas();
        quitarNumeros();

        String s ="Nivel: "+this.nivel;
        TextView t = (TextView) findViewById(R.id.editText200);
        t.setText(s);
    }

    private void quitarNumeros(){
        /*String s = String.valueOf(m);
        TextView t = (TextView) findViewById(R.id.editTextD1);

        switch(col){
            case 1: t = (TextView) findViewById(R.id.editTextN1); break;*/
        TextView t;

        t = (TextView) findViewById(R.id.editText8);
        t.setText("");
        t = (TextView) findViewById(R.id.editText4);
        t.setText("");
        t = (TextView) findViewById(R.id.editText5);
        t.setText("");
        t = (TextView) findViewById(R.id.editText6);
        t.setText("");
        t = (TextView) findViewById(R.id.editText7);
        t.setText("");
        t = (TextView) findViewById(R.id.editText2);
        t.setText("");
        t = (TextView) findViewById(R.id.editText18);
        t.setText("");
        t = (TextView) findViewById(R.id.editText19);
        t.setText("");
        t = (TextView) findViewById(R.id.editText20);
        t.setText("");
        t = (TextView) findViewById(R.id.editText21);
        t.setText("");
        t = (TextView) findViewById(R.id.editText22);
        t.setText("");
        t = (TextView) findViewById(R.id.editText9);
        t.setText("");
        t = (TextView) findViewById(R.id.editText23);
        t.setText("");
        t = (TextView) findViewById(R.id.editText24);
        t.setText("");
        t = (TextView) findViewById(R.id.editText25);
        t.setText("");
        t = (TextView) findViewById(R.id.editText26);
        t.setText("");
        t = (TextView) findViewById(R.id.editText27);
        t.setText("");
        t = (TextView) findViewById(R.id.editText10);
        t.setText("");
        t = (TextView) findViewById(R.id.editText28);
        t.setText("");
        t = (TextView) findViewById(R.id.editText29);
        t.setText("");
        t = (TextView) findViewById(R.id.editText30);
        t.setText("");
        t = (TextView) findViewById(R.id.editText31);
        t.setText("");
        t = (TextView) findViewById(R.id.editText32);
        t.setText("");
        t = (TextView) findViewById(R.id.editText38);
        t.setText("");
        t = (TextView) findViewById(R.id.editText33);
        t.setText("");
        t = (TextView) findViewById(R.id.editText34);
        t.setText("");
        t = (TextView) findViewById(R.id.editText35);
        t.setText("");
        t = (TextView) findViewById(R.id.editText36);
        t.setText("");
        t = (TextView) findViewById(R.id.editText37);
        t.setText("");
        t = (TextView) findViewById(R.id.editText12);
        t.setText("");
        t = (TextView) findViewById(R.id.editText51);
        t.setText("");
        t = (TextView) findViewById(R.id.editText13);
        t.setText("");
        t = (TextView) findViewById(R.id.editText15);
        t.setText("");
        t = (TextView) findViewById(R.id.editText16);
        t.setText("");
        t = (TextView) findViewById(R.id.editText17);
        t.setText("");
        t = (TextView) findViewById(R.id.editText11);
        t.setText("");
    }




    public void rellenarTablero(){
        int n = minas;
        int n1 = doses;
        int n2 = treses;
        while(n >0){
            int i = numeroAleatorio(0,5);
            int j = numeroAleatorio(0,5);
            if(matriz[i][j] ==0){
                matriz[i][j] = 9;
                n--;
            }
        }

        while(n1 >0){
            int i1 = numeroAleatorio(0,5);
            int j1 = numeroAleatorio(0,5);
            if(matriz[i1][j1] ==0){
                matriz[i1][j1] = 2;
                n1--;
            }
        }

        while(n2 >0){
            int i2 = numeroAleatorio(0,5);
            int j2 = numeroAleatorio(0,5);
            if(matriz[i2][j2] ==0){
                matriz[i2][j2] = 3;
                n2--;
            }
        }

        int m =0;
        int d =0;
        int t =0;
        int suma =0;

        for(int k =0; k<6; k++){
            m =0;
            d =0;
            t =0;
            suma =0;
            for(int l=0; l<6; l++){
                int valor = matriz[k][l];

                switch(valor){
                    case 0: if(this.invisible == false){
                                matriz[k][l] =1;
                             }
                            break;
                    case 2: d++; break;
                    case 3: t++; break;
                    case 9: m++; break;
                }
                if(valor != 9){
                    suma +=matriz[k][l];
                }
            }
            cargarTextoFilaMinas(k+1, m, suma);
        }



        for(int i1 =0; i1<6; i1++){
            m =0;
            d =0;
            t =0;
            suma =0;
            for(int j1=0; j1<6; j1++){
                int valor = matriz[j1][i1];
                switch(valor){
                    case 2: d++; break;
                    case 3: t++; break;
                    case 9: m++; break;
                }
                if(valor != 9){
                    suma +=matriz[j1][i1];
                }

            }
            cargarTextoFilaColumna(i1+1, m, suma);
        }
    }

    private void forzarMostrarCasillas(){
        forzar = true;
        for(int i=1; i<=6;i++){
            for(int j=1;j<=6;j++){
                voltearCasilla(i,j);
            }
        }
        mostrarFichas();

        if(invisible){
            quitarNumeros();
        }
    }
    private void voltearCasilla(int i, int j){

        if(matrizDestapadas[i-1][j-1] == false){
            matrizDestapadas[i-1][j-1] = true;
        }else{
            //ya se habia destapado la casilla
            if(forzar == false){
                Toast.makeText(Juego2.this,"Elige otra casilla", Toast.LENGTH_SHORT).show();
            }
            return;

        }

        int n = matriz[i-1][j-1];


        ImageView img;
        String s;
        TextView t = (TextView) findViewById(R.id.editText8);

        switch(i){
            case 1:
                switch(j){
                case 1: if(n == 9){
                    img = (ImageView) findViewById(R.id.imageView114);
                    img.setVisibility(View.VISIBLE);
                }else{
                    s = String.valueOf(n);
                    t = (TextView) findViewById(R.id.editText8);
                    t.setText(s);
                }

                    break;
                case 2: if(n == 9){
                    img = (ImageView) findViewById(R.id.imageView106);
                    img.setVisibility(View.VISIBLE);
                }else{
                    s = String.valueOf(n);
                    t = (TextView) findViewById(R.id.editText4);
                    t.setText(s);
                }

                    break;
                case 3: if(n == 9){
                    img = (ImageView) findViewById(R.id.imageView110);
                    img.setVisibility(View.VISIBLE);
                }else{
                    s = String.valueOf(n);
                    t = (TextView) findViewById(R.id.editText5);
                    t.setText(s);
                }

                    break;
                case 4: if(n == 9){
                    img = (ImageView) findViewById(R.id.imageView111);
                    img.setVisibility(View.VISIBLE);
                }else{
                    s = String.valueOf(n);
                    t = (TextView) findViewById(R.id.editText6);
                    t.setText(s);
                }

                    break;
                case 5: if(n == 9){
                    img = (ImageView) findViewById(R.id.imageView112);
                    img.setVisibility(View.VISIBLE);
                }else{
                    s = String.valueOf(n);
                    t = (TextView) findViewById(R.id.editText7);
                    t.setText(s);
                }

                    break;
                case 6: if(n == 9){
                    img = (ImageView) findViewById(R.id.imageView109);
                    img.setVisibility(View.VISIBLE);
                }else{
                    s = String.valueOf(n);
                    t = (TextView) findViewById(R.id.editText2);
                    t.setText(s);
                }

                    break;
            }
            break;




            case 2:
                switch(j){
                    case 1: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView135);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText18);
                        t.setText(s);
                    }

                        break;
                    case 2: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView113);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText19);
                        t.setText(s);
                    }

                        break;
                    case 3: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView120);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText20);
                        t.setText(s);
                    }

                        break;
                    case 4: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView137);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText21);
                        t.setText(s);
                    }

                        break;
                    case 5: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView122);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText22);
                        t.setText(s);
                    }

                        break;
                    case 6: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView118);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText9);
                        t.setText(s);
                    }

                        break;
                }
                break;
            case 3:
                switch(j){
                    case 1: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView136);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText23);
                        t.setText(s);
                    }

                        break;
                    case 2: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView138);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText24);
                        t.setText(s);
                    }

                        break;
                    case 3: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView139);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText25);
                        t.setText(s);
                    }

                        break;
                    case 4: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView140);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText26);
                        t.setText(s);
                    }

                        break;
                    case 5: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView141);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText27);
                        t.setText(s);
                    }

                        break;
                    case 6: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView119);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText10);
                        t.setText(s);
                    }

                        break;
                }
                break;
            case 4:
                switch(j){
                    case 1: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView145);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText28);
                        t.setText(s);
                    }

                        break;
                    case 2: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView148);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText29);
                        t.setText(s);
                    }

                        break;
                    case 3: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView149);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText30);
                        t.setText(s);
                    }

                        break;
                    case 4: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView151);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText31);
                        t.setText(s);
                    }

                        break;
                    case 5: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView150);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText32);
                        t.setText(s);
                    }

                        break;
                    case 6: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView152);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText38);
                        t.setText(s);
                    }

                        break;
                }
                break;
            case 5:
                switch(j){
                    case 1: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView124);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText33);
                        t.setText(s);
                    }

                        break;
                    case 2: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView125);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText34);
                        t.setText(s);
                    }

                        break;
                    case 3: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView126);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText35);
                        t.setText(s);
                    }

                        break;
                    case 4: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView128);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText36);
                        t.setText(s);
                    }

                        break;
                    case 5: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView127);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText37);
                        t.setText(s);
                    }

                        break;
                    case 6: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView117);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText12);
                        t.setText(s);
                    }

                        break;
                }
                break;
            case 6:
                switch(j){
                    case 1: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView132);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText51);
                        t.setText(s);
                    }

                        break;
                    case 2: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView130);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText13);
                        t.setText(s);
                    }

                        break;
                    case 3: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView131);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText15);
                        t.setText(s);
                    }

                        break;
                    case 4: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView115);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText16);
                        t.setText(s);
                    }

                        break;
                    case 5: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView133);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText17);
                        t.setText(s);
                    }

                        break;
                    case 6: if(n == 9){
                        img = (ImageView) findViewById(R.id.imageView129);
                        img.setVisibility(View.VISIBLE);
                    }else{
                        s = String.valueOf(n);
                        t = (TextView) findViewById(R.id.editText11);
                        t.setText(s);
                    }

                        break;
                }
                break;

        }

        if(invisible){
            if(t != null){
                t.setText("");
            }
        }
        if(forzar == false){
            calcularPuntuacion(n);
            if(n == 2 || n ==3){
                abiertos--;
            }
            if(abiertos ==0){
                Toast.makeText(Juego2.this,"NIVEL SUPERADO", Toast.LENGTH_SHORT).show();
                romperCrono();

                crearTimer();
            }
            if(n ==9){
                Toast.makeText(Juego2.this,"HAS PERDIDO", Toast.LENGTH_SHORT).show();
                romperCrono();
                forzar = true;
                this.nivel--;
                this.puntuacion =0;
                calcularPuntuacion(0);
                crearTimer();
            }

        }

    }
    private Timer timerC;
    private int segundosC =0;
    private int minutosC =2;
    private int decimasC =0;


    private void activarContrarreloj(){
        romperCrono();
        timerC = new Timer();
        timerC.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethodC();
            }
        },0,100);
    }

    private void TimerMethodC(){
        this.runOnUiThread(Timer_TickC);
    }

    private void romperCrono(){
        if(timerC!= null){
            timerC.cancel();
        }
     /*   TextView t;
        t = (TextView) findViewById(R.id.editText54);
        t.setText("0:00.0");*/
    }
    private Runnable Timer_TickC = new Runnable() {
        @Override
        public void run() {
            decimasC--;
            if(decimasC <0){
                segundosC--;
                decimasC =9;
            }
            if(segundosC <0){
                minutosC--;
                segundosC =59;
            }

            String s1 = String.valueOf(decimasC);

            String s2 = String.valueOf(segundosC);
            if(segundosC <10){
                s2 = "0"+String.valueOf(segundosC);
            }
            String s3 = String.valueOf(minutosC);
            String s = s3+":"+s2+"."+s1;
            TextView t;
            t = (TextView) findViewById(R.id.editText54);
            t.setText(s);
            if(minutosC <0){
                t.setText("0:00.0");
            }
            if(minutosC ==0 && segundosC ==0 && decimasC ==0){
              //  forzarMostrarCasillas();
                calcularPuntuacion(0);
                Toast.makeText(Juego2.this,"SE ACABÓ EL TIEMPO", Toast.LENGTH_SHORT).show();
                forzar = true;
                t.setText("0:00.0");
                romperCrono();
                nivel--;
                crearTimer();
                if(timerC!= null){
                    timerC.cancel();
                }
            }

            //  Toast.makeText(Juego2.this,"TEMPORIZADOR", Toast.LENGTH_SHORT).show();

        }
    };

    private Timer timer;
    private int segundos =0;
    private void crearTimer(){
        segundos =0;
        if(timer != null){
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethod();
            }
        },0,1000);

    }
    private void TimerMethod(){
        this.runOnUiThread(Timer_Tick);
    }
    private Runnable Timer_Tick = new Runnable() {
        @Override
        public void run() {
            segundos++;
            if(segundos ==2){
                forzarMostrarCasillas();
            }
            if(segundos ==5){
                crearTablero();
                if(timer != null){
                    timer.cancel();
                }

            }
          //  Toast.makeText(Juego2.this,"TEMPORIZADOR", Toast.LENGTH_SHORT).show();

        }
    };
    private void calcularPuntuacion(int valor){
        if(valor != 9){
            if(puntuacion ==0){
                puntuacion = valor;
            }else{
                puntuacion *=valor;
            }
        }
        String s = String.valueOf(puntuacion);
        TextView t = (TextView) findViewById(R.id.editText53);
        t.setText(s);
    }

    private void cargarTextoFilaColumna(int col, int m, int suma){
        String s = String.valueOf(m);
        String s2 = String.valueOf(suma);

        TextView t = (TextView) findViewById(R.id.editTextD1);
        TextView t2 = (TextView) findViewById(R.id.editTextD1);

        switch(col){
            case 1: t = (TextView) findViewById(R.id.editTextN1);
                    t2 = (TextView) findViewById(R.id.editText46);break;
            case 2: t = (TextView) findViewById(R.id.editTextN2);
                    t2 = (TextView) findViewById(R.id.editText48);break;
            case 3: t = (TextView) findViewById(R.id.editTextN3);
                    t2 = (TextView) findViewById(R.id.editText39);break;
            case 4: t = (TextView) findViewById(R.id.editTextN4);
                    t2 = (TextView) findViewById(R.id.editText49);break;
            case 5: t = (TextView) findViewById(R.id.editTextN5);
                    t2 = (TextView) findViewById(R.id.editText50);break;
            case 6: t = (TextView) findViewById(R.id.editTextN6);
                    t2 = (TextView) findViewById(R.id.editText47);break;
        }
        t.setText(s);
        t2.setText(s2);
    }
    private void cargarTextoFilaMinas(int fila, int m,int suma){
        String s = String.valueOf(m);
        String s2 = String.valueOf(suma);

        TextView t = (TextView) findViewById(R.id.editTextD1);
        TextView t2 = (TextView) findViewById(R.id.editTextD1);

        switch(fila){
            case 1: t = (TextView) findViewById(R.id.editTextD1);
                    t2 = (TextView) findViewById(R.id.editText40);break;
            case 2: t = (TextView) findViewById(R.id.editTextD2);
                    t2 = (TextView) findViewById(R.id.editText41);break;
            case 3: t = (TextView) findViewById(R.id.editTextD3);
                    t2 = (TextView) findViewById(R.id.editText42);break;
            case 4: t = (TextView) findViewById(R.id.editTextD4);
                    t2 = (TextView) findViewById(R.id.editText43);break;
            case 5: t = (TextView) findViewById(R.id.editTextD5);
                    t2 = (TextView) findViewById(R.id.editText44);break;
            case 6: t = (TextView) findViewById(R.id.editTextD6);
                    t2 = (TextView) findViewById(R.id.editText45);break;
        }
        t.setText(s);
        t2.setText(s2);


    }
    /**
     * Devuelve un numero aleatorio comprendido entre desde y hasta, ambos incluidos
     * @param desde
     * @param hasta
     * @return
     */
    public int numeroAleatorio(int desde, int hasta){
        Random r = new Random();
        int n = r.nextInt(hasta-desde+1)+desde;
        return n;
    }
    public void sumarNivel(){
        this.nivel++;
    }

    public void crearTablero(){
        //TextView t = (TextView) findViewById(R.id.editTextN4);
        //t.setText("5");
        this.nivel++;
        esconderFichas();
        vaciarMatriz();
        cargarNivel();

        if(this.modoContrarreloj){
            activarContrarreloj();
        }


        /*añadir estas lineas cuando se cree un plain text
        android:clickable="false"
        android:cursorVisible="false"
        android:focusable="false"
        android:focusableInTouchMode="false"
        android:background="@null"
        */
    }

    public void quitarMinas(){
        ImageView i;
        i = (ImageView) findViewById(R.id.imageView114);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView106);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView110);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView111);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView112);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView109);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView135);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView113);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView120);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView137);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView122);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView118);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView136);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView138);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView139);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView140);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView141);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView119);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView145);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView148);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView149);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView151);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView150);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView152);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView124);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView125);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView126);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView128);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView127);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView117);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView132);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView130);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView131);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView115);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView133);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView129);
        i.setVisibility(View.INVISIBLE);
    }

    public void esconderFichas(){

        ImageView i;
        i = (ImageView) findViewById(R.id.imageView39);
        i.setVisibility(View.INVISIBLE);

        i = (ImageView) findViewById(R.id.imageView68);
        i.setVisibility(View.INVISIBLE);

        i = (ImageView) findViewById(R.id.imageView71);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView72);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView73);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView74);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView75);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView76);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView77);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView78);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView79);
        i.setVisibility(View.INVISIBLE);

        i = (ImageView) findViewById(R.id.imageView80);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView81);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView82);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView83);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView84);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView85);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView86);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView87);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView88);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView89);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView90);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView91);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView92);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView93);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView94);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView95);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView96);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView97);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView98);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView99);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView100);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView101);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView102);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView103);
        i.setVisibility(View.INVISIBLE);
        i = (ImageView) findViewById(R.id.imageView104);
        i.setVisibility(View.INVISIBLE);
        /*
        for(int j=71; j<=104; j++){
            i =(ImageView) findViewById(R.id.imageView+j);
            if(i != null){
                i.setVisibility(View.INVISIBLE);
            }
        }
       */
    }



    public void mostrarFichas(){

        ImageView i;
        i = (ImageView) findViewById(R.id.imageView39);
        i.setVisibility(View.VISIBLE);

        i = (ImageView) findViewById(R.id.imageView68);
        i.setVisibility(View.VISIBLE);

        i = (ImageView) findViewById(R.id.imageView71);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView72);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView73);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView74);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView75);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView76);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView77);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView78);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView79);
        i.setVisibility(View.VISIBLE);

        i = (ImageView) findViewById(R.id.imageView80);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView81);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView82);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView83);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView84);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView85);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView86);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView87);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView88);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView89);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView90);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView91);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView92);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView93);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView94);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView95);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView96);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView97);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView98);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView99);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView100);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView101);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView102);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView103);
        i.setVisibility(View.VISIBLE);
        i = (ImageView) findViewById(R.id.imageView104);
        i.setVisibility(View.VISIBLE);
    }


    public void clickNew_1_1(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView104);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }

        voltearCasilla(1,1);
  /*      int n = numeroAleatorio(0,5);
        String s = String.valueOf(n);
        TextView t = (TextView) findViewById(R.id.editTextN4);
        t.setText(s);*/
        /*
        int n = numeroAleatorio(0,5);
        TextView t = (TextView) findViewById(R.id.editTextN1);
        t.setText(n);*/
    }

    public void clickNew_1_2(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView39);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(1,2);
    }

    public void clickNew_1_3(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView76);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(1,3);
    }

    public void clickNew_1_4(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView82);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(1,4);
    }

    public void clickNew_1_5(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView88);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(1,5);

    }

    public void clickNew_1_6(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView87);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(1,6);
    }



    public void clickNew_2_1(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView73);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(2,1);
    }

    public void clickNew_2_2(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView72);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(2,2);
    }

    public void clickNew_2_3(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView81);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(2,3);
    }

    public void clickNew_2_4(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView89);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(2,4);
    }

    public void clickNew_2_5(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView85);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(2,5);
    }

    public void clickNew_2_6(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView98);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(2,6);
    }


    public void clickNew_3_1(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView71);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(3,1);
    }

    public void clickNew_3_2(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView77);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(3,2);
    }

    public void clickNew_3_3(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView74);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(3,3);
    }

    public void clickNew_3_4(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView86);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(3,4);
    }

    public void clickNew_3_5(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView97);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(3,5);
    }

    public void clickNew_3_6(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView100);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(3,6);
    }



    public void clickNew_4_1(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView75);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(4,1);
    }

    public void clickNew_4_2(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView78);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(4,2);
    }

    public void clickNew_4_3(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView84);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(4,3);
    }

    public void clickNew_4_4(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView83);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(4,4);
    }

    public void clickNew_4_5(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView99);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(4,5);
    }

    public void clickNew_4_6(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView96);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(4,6);
    }



    public void clickNew_5_1(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView80);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(5,1);
    }

    public void clickNew_5_2(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView79);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(5,2);
    }

    public void clickNew_5_3(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView92);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(5,3);
    }

    public void clickNew_5_4(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView93);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(5,4);
    }

    public void clickNew_5_5(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView94);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(5,5);
    }

    public void clickNew_5_6(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView103);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(5,6);
    }


    public void clickNew_6_1(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView68);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(6,1);

    }

    public void clickNew_6_2(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView90);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(6,2);
    }

    public void clickNew_6_3(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView91);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(6,3);
    }

    public void clickNew_6_4(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView95);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(6,4);
    }

    public void clickNew_6_5(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView101);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(6,5);
    }

    public void clickNew_6_6(View v){
        ImageView i = (ImageView) findViewById(R.id.imageView102);
        if(i != null){
            i.setVisibility(View.VISIBLE);
        }
        voltearCasilla(6,6);
    }






    protected void onDestroy() {
        romperCrono();
        if(timer != null){
            timer.cancel();
        }
        super.onDestroy();

    }


}
