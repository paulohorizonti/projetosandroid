package app.daazi.v1.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;
import app.daazi.v1.appclientevip.R;
import app.daazi.v1.appclientevip.api.ApiUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//tira a barra de titulo
        setContentView(R.layout.activity_splash);

        iniciarAplicativo();
    }

    private void iniciarAplicativo() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(
                        SplashActivity.this,
                        LoginActivity.class
                );
                startActivity(intent);

                //evita a volta a tela
                finish();
                return;
            }
        }, ApiUtil.TIME_SPLASH);

        }

    }



