package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        double nota1, nota2, media;
        int freq;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Intent it = getIntent();

        if (it != null) {
            Bundle params = it.getExtras();

            if (params != null) {
                nota1 = params.getDouble("nota1", 0.0);
                nota2 = params.getDouble("nota2", 0.0);
                freq  = params.getInt("freq", 0);

                media = (nota1 + nota2 ) / 2;

                TextView outputMedia = findViewById(R.id.textViewMedia);
                TextView outputSituacao = findViewById(R.id.textViewSituacao);

                System.out.println("nota1="+nota1);
                System.out.println("nota2="+nota2);
                System.out.println("media="+media);
                System.out.println("freq="+freq);

                if (freq < 75)
                    outputSituacao.setText("Reprovado por falta");
                else if (media < 4.0)
                    outputSituacao.setText("Reprovado por nota");
                else if (media >= 7.0)
                    outputSituacao.setText("Aprovado");
                else
                    outputSituacao.setText("Final");

                outputMedia.setText(String.format("%.2f", media));
            }
        }
    }
}