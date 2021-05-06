package com.example.posaderos;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class carga_datos1 extends AppCompatActivity {

    EditText ednombre, edapellido, eddni,edfecha, edobser ;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_datos1);


        ednombre = (EditText)findViewById(R.id.editTextNombre);
        edapellido = (EditText)findViewById(R.id.editTextApellido);
        eddni = (EditText)findViewById(R.id.editTextDni);
        edfecha = (EditText)findViewById(R.id.editTextDate);
        edobser = (EditText)findViewById(R.id.editTextObservaciones);
        btnEnviar = (Button)findViewById(R.id.button);

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
                parametros.put("nombre",ednombre.getText().toString());
                parametros.put("apellido",edapellido.getText().toString());
                parametros.put("dni",eddni.getText().toString());
                parametros.put("fechaNacimiento",edfecha.getText().toString());
                parametros.put("observaciones",edobser.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}