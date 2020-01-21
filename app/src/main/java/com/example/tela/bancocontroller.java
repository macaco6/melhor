package com.example.tela;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static com.example.tela.criaBanco.EMAIL;
import static com.example.tela.criaBanco.SENHA;
import static com.example.tela.criaBanco.TABELA;

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
        valores.put(EMAIL, autor);
        valores.put(SENHA, editora);

        resultado = db.insert(TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Error inserting record";
        else
            return "Registration successfully inserted";


    }

    public Cursor fazerLogin(String email,String senha) {
        db = banco.getWritableDatabase();
        String sql = "SELECT * FROM " + TABELA + " WHERE " + EMAIL + " = ? AND " + SENHA + " = ?";
        String[] selectionArgs = new String[]{email,senha};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor != null) {
            cursor.moveToFirst();
            return cursor;
        } else {
            return null;
        }
    }
}