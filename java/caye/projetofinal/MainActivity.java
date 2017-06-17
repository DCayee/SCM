package caye.projetofinal;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enviar = (Button)findViewById(R.id.enviar);
        Button listar = (Button)findViewById(R.id.listar);

        //EditText nome = (EditText)findViewById(R.id.editText);

        //nome.setText(nome.getText().toString(), TextView.BufferType.EDITABLE);

        enviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                BancoController crud = new BancoController(getBaseContext());
                EditText nome = (EditText)findViewById(R.id.editText);
                String nomeString = nome.getText().toString();

                EditText status = (EditText) findViewById(R.id.editTextDois);
                String statusString = status.getText().toString();

                String resultado;

                resultado = crud.insereDados(nomeString, statusString); // duplicando o que esta sendo enviado pq sim
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });

        listar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(MainActivity.this, Listar.class);
                startActivity(intent);

            }
        });

    }
}
