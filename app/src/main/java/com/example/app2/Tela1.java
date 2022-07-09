package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Tela1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
    }

    public void situacao(View view) {
        EditText inputNome = findViewById(R.id.editTextNome);
        EditText inputNota1 = findViewById(R.id.editTextNota1);
        EditText inputNota2 = findViewById(R.id.editTextNota2);
        EditText inputFreq = findViewById(R.id.editTextFrequencia);

        double nota1, nota2;
        int freq;

        System.out.println("length="+inputNota1.length());

        if (inputNome.length() == 0)
            Toast.makeText(this, "Informe o Nome", Toast.LENGTH_SHORT).show();
        else  if (inputNota1.length() == 0)
            Toast.makeText(this, "Informe a Nota 1", Toast.LENGTH_SHORT).show();
        else  if (inputNota2.length() == 0)
            Toast.makeText(this, "Informe a Nota 2", Toast.LENGTH_SHORT).show();
        else  if (inputFreq.length() == 0)
            Toast.makeText(this, "Informe a Frequência", Toast.LENGTH_SHORT).show();
        else {

            nota1 = Double.parseDouble(inputNota1.getText().toString());
            nota2 = Double.parseDouble(inputNota2.getText().toString());
            freq = Integer.parseInt(inputFreq.getText().toString());

            if (nota1 < 0.0 || nota1 > 10.0)
                Toast.makeText(this, "Nota 1 deve estar entre 0 e 10", Toast.LENGTH_SHORT).show();
            else if (nota2 < 0.0 || nota2 > 10.0)
                Toast.makeText(this, "Nota 2 deve estar entre 0 e 10", Toast.LENGTH_SHORT).show();
            else if (freq < 0 || freq > 100)
                Toast.makeText(this, "Frequência deve estar entre 0 e 100", Toast.LENGTH_SHORT).show();
            else {

                Bundle params = new Bundle();
                params.putString("nome", inputNome.getText().toString());
                params.putDouble("nota1", nota1);
                params.putDouble("nota2", nota2);
                params.putInt("freq", freq);

                Intent it = new Intent(this, Tela2.class);
                it.putExtras(params);

                startActivity(it);
            }
        }
    }
}