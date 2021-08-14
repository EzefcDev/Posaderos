package com.example.posaderos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class carga_datos1 extends AppCompatActivity {

    private EditText editText1, editText2, editText3, editText4, editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_datos1);

        editText1 = findViewById(R.id.editTextName);
        editText2 = findViewById(R.id.editTextApellido);
        editText3 = findViewById(R.id.editTextDni);
        editText4 = findViewById(R.id.editTextDate);
        editText5 = findViewById(R.id.editTextObservaciones);
    }
    public void siguiente(View v){
        Intent envio= new Intent(this,carga_datos2.class);

        String nombre = editText1.getText().toString();
        String apellido = editText2.getText().toString();
        String dni = editText3.getText().toString();
        String fecha = editText4.getText().toString();
        boolean letraNombre = false;
        boolean letraApellido = false;

        if(nombre.length() == 0 ){
            Toast.makeText(this, "Debes completar el campo Nombre", Toast.LENGTH_LONG).show();
        }else{
            letraNombre = contieneSoloLetras(nombre);
            if(!letraNombre){
                Toast.makeText(this, "El campo Nombre contiene caracteres que no son letras", Toast.LENGTH_LONG).show();
            }else{
                if(apellido.length() == 0 ){
                    Toast.makeText(this, "Debes completar el campo Apellido", Toast.LENGTH_LONG).show();
                }else{
                    letraApellido = contieneSoloLetras(apellido);
                    if(!letraApellido){
                        Toast.makeText(this, "El campo Apellido contiene caracteres que no son letras", Toast.LENGTH_LONG).show();
                    }else{
                        if(dni.length() < 7 ){
                            Toast.makeText(this, "Debes completar el campo DNI", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        }
        if (nombre.length() != 0 && letraNombre && apellido.length() != 0 &&
                letraApellido && dni.length() >= 7){

            envio.putExtra("datos", nombre );
            envio.putExtra("datos1", apellido );
            envio.putExtra("datos2", dni);
            envio.putExtra("datos3", fecha);
            envio.putExtra("datos4", editText5.getText().toString());
            startActivity(envio);
        }
    }
    public static boolean contieneSoloLetras(String cadena) {
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            // Si no está entre a y z, ni entre A y Z, ni es un espacio
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }
    public void Atras1(View v){
        Intent atras = new Intent(this,MainActivity.class);
        startActivity(atras);
    }
}