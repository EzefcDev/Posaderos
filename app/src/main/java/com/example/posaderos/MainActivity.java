package com.example.posaderos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private Button registrase;
    private ImageButton instagram, facebook;

    // declaración de las variable para la url
    private String urlReg, urlInst, urlFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // asignacion de nombre para los botones
        registrase = findViewById(R.id.Boton2);
        instagram = findViewById(R.id.ImBinst);
        facebook = findViewById(R.id.ImBFace);
        //twitter= findViewById(R.id.ImBtwit);

        // declaracion de las url
        urlReg = "https://www.posaderos.org/register";
        urlInst = "https://www.instagram.com/lumen_cor/?hl=es-la";
        urlFace = "https://www.facebook.com/lumen.cor";


        //metodo boton registrarse y redes sociales
        registrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(urlReg);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(urlInst);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Uri uri = Uri.parse(urlFace);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
             }
        });

    }

    //metodo boton invitado
     public void Invitado (View view){
     Intent invitado = new Intent(this,Alerta.class);
     startActivity(invitado);
    }

}