package com.example.posaderos;



import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splash_lumen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_lumen);

        int DURACION_SPLASH = 3000;
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(splash_lumen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, DURACION_SPLASH);
    }
}