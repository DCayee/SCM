package caye.projetofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereDados(String nome, String status) {

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME_CHUVEIRO, nome);
        valores.put(CriaBanco.STATUS_CHUVEIRO, status);
        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado == -1) {
            return "ERRO ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }


    public Cursor carregaDados() {
        Cursor cursor;
        db = banco.getReadableDatabase();

        String[] campos = {CriaBanco.ID, CriaBanco.NOME_CHUVEIRO, CriaBanco.STATUS_CHUVEIRO};
        cursor = db.query(CriaBanco.TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();

        return cursor;
    }

    public Cursor carregaDadosById(int id) {
        Cursor cursor;
        String[] campos = {CriaBanco.ID, CriaBanco.NOME_CHUVEIRO, CriaBanco.STATUS_CHUVEIRO};
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();

        return cursor;
    }

    public void alterar(int id, String nome, String status) {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.ID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.NOME_CHUVEIRO, nome);
        valores.put(CriaBanco.STATUS_CHUVEIRO, status);

        db.update(CriaBanco.TABELA, valores, where, null);
        db.close();
    }

    public void deletar(int id) {
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA, where, null);
        db.close();
    }
}