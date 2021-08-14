package com.example.posaderos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class carga_datos2 extends AppCompatActivity {
    private EditText editText1;
    String dato, dato1, dato2, dato3, dato4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_datos2);

        editText1 = findViewById(R.id.spinnerInstitucion);

        dato = getIntent().getStringExtra("datos");
        dato1 = getIntent().getStringExtra("datos1");
        dato2 = getIntent().getStringExtra("datos2");
        dato3 = getIntent().getStringExtra("datos3");
        dato4 = getIntent().getStringExtra("datos4");

    }
    public void siguiente2(View v){
        Intent siguiente = new Intent(this, carga_confirmacion.class);
        siguiente.putExtra("datos1", editText1.getText().toString());
        siguiente.putExtra("datos2",dato);
        siguiente.putExtra("datos3",dato1);
        siguiente.putExtra("datos4",dato2);
        siguiente.putExtra("datos5",dato3);
        siguiente.putExtra("datos6",dato4);
        startActivity(siguiente);
    }
    public void atras2(View v){
        Intent atras= new Intent(this,carga_datos1.class);
        startActivity(atras);
    }

}