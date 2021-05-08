package com.example.posaderos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class carga_datos1 extends AppCompatActivity {

    private EditText et1, et2, et3, et4, et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 =(EditText)findViewById(R.id.editTextNombre);
        et2 =(EditText)findViewById(R.id.editTextApellido);
        et3 =(EditText)findViewById(R.id.editTextDni);
        et4 =(EditText)findViewById(R.id.editTextDate);
        et5 =(EditText)findViewById(R.id.editTextObservaciones);
    }
    public void siguiente(View v){
        Intent envio= new Intent(this, carga_datos2.class);

        String nombre = et1.getText().toString();
        String apellido = et2.getText().toString();
        String dni = et3.getText().toString();
        String fecha = et4.getText().toString();

        if(nombre.length() == 0 ){
            Toast.makeText(this, "Debes completar el campo Nombre", Toast.LENGTH_LONG).show();
        }
        if(apellido.length() == 0 ){
            Toast.makeText(this, "Debes completar el campo Apellido", Toast.LENGTH_LONG).show();
        }
        if(dni.length() == 0 ){
            Toast.makeText(this, "Debes completar el campo DNI", Toast.LENGTH_LONG).show();
        }
        if(fecha.length() == 0 ){
            Toast.makeText(this, "Debes completar el campo Fecha", Toast.LENGTH_LONG).show();
        }
        if (nombre.length() != 0 && apellido.length() != 0 && dni.length() != 0 && fecha.length() != 0){

            envio.putExtra("datos", nombre );
            envio.putExtra("datos1", apellido );
            envio.putExtra("datos2", dni);
            envio.putExtra("datos3", fecha);
            envio.putExtra("datos4", et5.getText().toString());
            startActivity(envio);
        }
    }
}