package app.daazi.v1.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;
import app.daazi.v1.appclientevip.R;
import app.daazi.v1.appclientevip.api.ApiUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Nome da classe - declara um objeto
    TextView txtTitulo;
    TextView txtDataAtual;
    TextView txtHoraAtual;

    Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //faz a conexao do objeto com o componente da tela
        txtTitulo = findViewById(R.id.txtTitulo);
        txtDataAtual = findViewById(R.id.txtData);
        txtHoraAtual = findViewById(R.id.txtHora);
        btnCadastro = findViewById(R.id.btnCadastro);

        txtTitulo.setText("Curso Android");
        txtTitulo.setTextColor(getResources().getColor(R.color.colorTextView));
        /*Atribuindo os valores*/
        txtDataAtual.setText(ApiUtil.getDataAtual());
        txtHoraAtual.setText(ApiUtil.getHoraAtual());

        /*Metodo clicklistener para o botao*/
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    /*Objeto intent*/
                Intent iTelaCadastro = new Intent(MainActivity.this, CadastroUsuarioActivity.class);
                startActivity(iTelaCadastro);
            }
        });
    }
}
