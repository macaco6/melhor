package com.example.tela;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class bancocontroller {

    private SQLiteDatabase db;
    private criaBanco banco;

    public bancocontroller(Context context){
        banco = new criaBanco(context);
    }

    public String insereDado(String titulo, String autor, String editora){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(criaBanco.NOME, titulo);
        valores.put(criaBanco.EMAIL, autor);
        valores.put(criaBanco.SENHA, editora);

        resultado = db.insert(criaBanco.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Error inserting record";
        else
            return "Registration successfully inserted";

    }
}