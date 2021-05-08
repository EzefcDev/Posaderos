package com.example.posaderos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra);

        tv1=(TextView)findViewById(R.id.textM);
        btnEnviar = (Button)findViewById(R.id.button);

        Bundle extras = getIntent().getExtras();
        datos = extras.getString("datos1");
        datos1 = extras.getString("datos2");
        datos2 = extras.getString("datos3");
        datos3 = extras.getString("datos4");
        datos4 = extras.getString("datos5");
        datos5 = extras.getString("datos6");

        tv1.setText(datos1 + datos2 + datos3 + datos4 + datos5 + datos );

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://192.168.100.17:80/devposaderos/carga_datos.php");

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
    }


    public void atras(View v){
        Intent atras= new Intent(this, carga_datos2.class);
        startActivity(atras);
    }

}