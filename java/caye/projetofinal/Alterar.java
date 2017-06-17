package caye.projetofinal;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Alterar extends Activity {


    EditText nome;
    Button alterar;
    Button excluir;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alterar);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        nome = (EditText)findViewById(R.id.editText);

        alterar = (Button)findViewById(R.id.alterar);
        excluir = (Button)findViewById(R.id.excluir);

        cursor = crud.carregaDadosById(Integer.parseInt(codigo));
        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOME_CHUVEIRO)));

        alterar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                crud.alterar(Integer.parseInt(codigo), nome.getText().toString(), nome.getText().toString()); // colocado mais um so para fazer rodar. depois deve pegar da outra coluna
                Intent intent = new Intent(Alterar.this, Listar.class);
                startActivity(intent);

                textView2.setVisibility(View.INVISIBLE);


                finish();
            }
        });

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crud.deletar((Integer.parseInt(codigo)));
                Intent intent = new Intent(Alterar.this, Listar.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
