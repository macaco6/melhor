package com.example.tela;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }

    public void map (View view){

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void tela4cadastro (View view){

        Intent intent = new Intent(this, tela4cadastro.class);
        startActivity(intent);
    }
    public void login(View view){
        EditText email = findViewById(R.id.email);
        EditText senha = findViewById(R.id.senha);
        String strEmail = email.getText().toString();
        String strSenha = senha.getText().toString();
        boolean erro = false;

        if(strEmail.length() > 0 && strSenha.length() > 0){
            bancocontroller crud = new bancocontroller(getBaseContext());
            Cursor cursor = crud.fazerLogin(strEmail,strSenha);
            if(cursor == null || cursor.getCount() == 0){
                erro = true; }
            else {
                String resEmail = cursor.getString(cursor.getColumnIndex("email"));
                String resSenha = cursor.getString(cursor.getColumnIndex("senha"));
                if (strEmail.equals(resEmail) && strSenha.equals(resSenha)) {
                    Toast.makeText(getApplicationContext(), "Seja bem-vindo.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, tela3.class);
                    startActivity(intent);
                } else {
                    erro = true;
                }
            }
        }else{
            erro = true; }
        if(erro)
            Toast.makeText(getApplicationContext(), "Credenciais incorretas.", Toast.LENGTH_LONG).show();
    }
    }

