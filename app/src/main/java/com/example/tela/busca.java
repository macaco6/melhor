package com.example.tela;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class busca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca);

        final EditText etCep = findViewById(R.id.etMain_cep);

        Button btnBuscarCep = findViewById(R.id.btnMain_buscarCep);
        btnBuscarCep.setOnClickListener(new View.OnClickListener());
        {
            public void onClick (View busca){
            if (etCep.getText().toString().length() > 0 && !etCep.getText().toString().equals(" ") && etCep.getText().toString().length() == 8) {
                Log.i("teste", "CEP valido");


            }
        }
            ;
        }

    }

}