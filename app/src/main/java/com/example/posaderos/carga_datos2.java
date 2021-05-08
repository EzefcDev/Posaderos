package com.example.posaderos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class carga_datos2 extends AppCompatActivity {

    private EditText et1;
    String d, d1, d2, d3, d4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dato);

        et1 =(EditText)findViewById(R.id.editInfo1);

        d = getIntent().getStringExtra("datos");
        d1 = getIntent().getStringExtra("datos1");
        d2 = getIntent().getStringExtra("datos2");
        d3 = getIntent().getStringExtra("datos3");
        d4 = getIntent().getStringExtra("datos4");


    }
    public void siguiente(View v){
        Intent siguiente = new Intent(this,muestra.class);
        siguiente.putExtra("datos1", et1.getText().toString());
        siguiente.putExtra("datos2",d);
        siguiente.putExtra("datos3",d1);
        siguiente.putExtra("datos4",d2);
        siguiente.putExtra("datos5",d3);
        siguiente.putExtra("datos6",d4);
        startActivity(siguiente);
    }
    public void atras(View v){
        Intent atras= new Intent(this, carga_datos1.class);
        startActivity(atras);
    }

}