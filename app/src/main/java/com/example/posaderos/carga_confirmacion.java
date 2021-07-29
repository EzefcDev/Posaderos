package com.example.posaderos;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class carga_confirmacion extends AppCompatActivity {

    private TextView tv1;
    Button btnEnviar;
    String datos1,datos2,datos3,datos4,datos5,datos;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_confirmacion);

        tv1= findViewById(R.id.tv1);
        btnEnviar = findViewById(R.id.button5);

        Bundle extras = getIntent().getExtras();
        datos = extras.getString("datos1");
        datos1 = extras.getString("datos2");
        datos2 = extras.getString("datos3");
        datos3 = extras.getString("datos4");
        datos4 = extras.getString("datos5");
        datos5 = extras.getString("datos6");

        tv1.setText("Nombre: " + datos1 + "\n Apellido: " + datos2 + "\n DNI: " + datos3 + "\n Fecha de nacimiento: " + datos4 + "\n Obsercion: " + datos5 + "\n Institucion: " + datos);

        btnEnviar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://192.168.100.17:80/devposaderos/carga_datos.php"); //aqui se cambia la ip y el puerto
            }
        });

    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("nombre",datos1);
                parametros.put("apellido",datos2);
                parametros.put("dni",datos3);
                parametros.put("fechaNacimiento", datos4);
                parametros.put("observaciones",datos5);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Intent confirmacion= new Intent(this,pantalla_final.class);
        startActivity(confirmacion);
    }

    public void atras(View v){
        Intent atras= new Intent(this, carga_datos2.class);
        startActivity(atras);
    }
}