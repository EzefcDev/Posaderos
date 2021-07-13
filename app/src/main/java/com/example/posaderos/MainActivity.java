package com.example.posaderos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // asignacion de nombre para los botones
    @SuppressLint("WrongViewCast")
    private final ImageButton instagram = findViewById(R.id.imgBinsta);
    @SuppressLint("WrongViewCast")
    private final ImageButton facebook = findViewById(R.id.imgBface);
    @SuppressLint("WrongViewCast")
    private final ImageButton lumencor = findViewById(R.id.imgBlumen);

    // declaración de las variable para la url
    private String urlInst, urlFace, urlLum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declaración de las url
        urlLum = "https://www.lumencor.org";
        urlInst = "https://www.instagram.com/lumen_cor/?hl=es-la";
        urlFace = "https://www.facebook.com/lumen.cor";


        //metodo botones redes sociales
        lumencor.setOnClickListener(view -> {
            Uri uri = Uri.parse(urlLum);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

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

    }

    //metodo boton
     public void PantAlerta(View view){
     Intent activity = new Intent(this,carga_datos1.class);
     startActivity(activity);
    }

}