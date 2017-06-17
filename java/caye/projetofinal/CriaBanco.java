package caye.projetofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "chuveiro21.db";

    public static final String TABELA = "usuario";
    public static final String ID = "_id";
    public static final String NOME_CHUVEIRO = "nome";
    public static final String STATUS_CHUVEIRO = "status";


    public static final int VERSAO = 1;

    public CriaBanco(Context context) {

        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + " ( "
                + ID + " integer primary key autoincrement, "
                + NOME_CHUVEIRO + " text, "
                + STATUS_CHUVEIRO + " text"
                + ")";
        db.execSQL(sql);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);onCreate(db);
    }
}