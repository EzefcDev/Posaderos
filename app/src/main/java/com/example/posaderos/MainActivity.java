package com.example.posaderos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton instagram, facebook, lumen;
    // declaración de las variable para la url
    private String urlInst, urlFace, urlLum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // asignacion de nombre para los botones

        instagram = findViewById(R.id.ImgBinst);
        facebook = findViewById(R.id.ImgBFace);
        lumen= findViewById(R.id.ImgBlumen);

        // declaracion de las url

        urlInst = "https://www.instagram.com/lumen_cor/?hl=es-la";
        urlFace = "https://www.facebook.com/lumen.cor";
        urlLum = "https://www.lumencor.org/";

        //metodo boton redes sociales
        instagram.setOnClickListener(view -> {
            Uri uri = Uri.parse(urlInst);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        facebook.setOnClickListener(view -> {
             Uri uri = Uri.parse(urlFace);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
         });

        lumen.setOnClickListener(view -> {
                Uri uri = Uri.parse(urlLum);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
        });
    }

    //metodo boton invitado
     public void GenerarSoS (View view){
     Intent invitado = new Intent(this,carga_datos1.class);
     startActivity(invitado);
    }

}