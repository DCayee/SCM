package caye.projetofinal;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Listar extends Activity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar);

        BancoController crud = new BancoController(getBaseContext());

        final Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[]{CriaBanco.ID, CriaBanco.NOME_CHUVEIRO, CriaBanco.STATUS_CHUVEIRO};
        int[] idView = new int[]{R.id.data_e_hora, R.id.nome, R.id.status}; // dupliquei nome

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.usuario_layout, cursor, nomeCampos, idView, 0);

        lista = (ListView)findViewById(R.id.lista);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ID));

                Intent intent = new Intent(Listar.this, Alterar.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();

            }
        });



    }
}
