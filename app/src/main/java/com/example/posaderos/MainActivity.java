package com.example.posaderos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button reg;
    private String url; // declaracion de la variable para la url

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg = findViewById(R.id.Boton2); // asignacion de nombre para el Boton2

        url = "https://www.posaderos.org/register"; // declaracion de la url de registro

        //metodo boton registrarse
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url);
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