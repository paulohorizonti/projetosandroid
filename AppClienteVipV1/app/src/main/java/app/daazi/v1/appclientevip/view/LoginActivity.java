package app.daazi.v1.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;
import app.daazi.v1.appclientevip.R;
import app.daazi.v1.appclientevip.controler.ClienteControler;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    //Declaração dos componentes da tela

    EditText editEmail, editSenha;;
    CheckBox chkLembrar;
    TextView txtRecSenha;
    TextView lerPolitica;
    Button btnAcessar, btnSejaVip;

    boolean isFormularioOk, isLembrarSenha; //variavel para verificar se o formulario esta ok


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //tira a barra de titulo
        setContentView(R.layout.activity_login);

        //inicia os componentes
        initFormulario();

        //botao chama o validador
        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //executa o validador
               if(isFormularioOk = validarFormulario()){

                   //verifica o retorno do metodo que foi gerado na classe controler, se der true chama a tela
                   if(validarDadosUsuario()){
                       Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                       startActivity(intent);
                       finish();
                       return;
                   }else{
                       Toast.makeText(getApplicationContext(), "Verifique os dados por vafor", Toast.LENGTH_LONG).show();
                   }
               }

            }
        });

        //validar formulario
        isFormularioOk = validarFormulario(); //recebe o retorno desse form

        /*clique no texto de recuperar senha */
        txtRecSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Carregando tela de recupear senha...",
                        Toast.LENGTH_LONG).show();
            }
        });

        /*clique no texto de ler politica */
        lerPolitica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Carregar tela de ler politica de privacidade...",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private boolean validarFormulario() {
        //validar
        boolean retorno = true;//considera que ta tudo ok

        //começa a testar
        if(TextUtils.isEmpty(editEmail.getText().toString())){
            editEmail.setError("*"); //coloca asterisco
            editEmail.requestFocus(); //seta o foco
            retorno = false; //atribui false ao retorno
        }

        if(TextUtils.isEmpty(editSenha.getText().toString())){
            editSenha.setError("*"); //coloca asterisco
            editSenha.requestFocus(); //seta o foco
            retorno = false; //atribui false ao retorno
        }



        return retorno;
    }

    private void initFormulario() {
        //inicializando os componentes
        txtRecSenha = findViewById(R.id.txtRecSenha);
        lerPolitica = findViewById(R.id.txtLerPolitica);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        chkLembrar = findViewById(R.id.chkLembrar);
        btnAcessar  =findViewById(R.id.btnAcessar);
        btnSejaVip  = findViewById(R.id.btnSejaVip);


    }
    //metodo que vai lembarar a senha
    public void lembrarSenha(View view) {
        //atributo recebe o checado do chbox
        isLembrarSenha = chkLembrar.isChecked();
    }

    //validar senha do usuario
    public boolean validarDadosUsuario(){
        return ClienteControler.validarDadosCliente(); //chama o metodo na classe controler para validacao dos dados
    }
}
