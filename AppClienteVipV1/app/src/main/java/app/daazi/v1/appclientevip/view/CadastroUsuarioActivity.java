package app.daazi.v1.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;
import app.daazi.v1.appclientevip.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroUsuarioActivity extends AppCompatActivity {
    //1° Passo: Declarar os componentes da tela - componentes do xml
    Button btnCadastro;
    EditText editNome;
    EditText editEmail;
    EditText editSenhaA;
    EditText editSenhaB;
    CheckBox chTermo;

    //variavel booleana para verificar se o form esta ok
    boolean isFormOk;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //tira a barra de titulo
        setContentView(R.layout.activity_cadastro_usuario);

        //2° Passo : Metodo para inicializar os objetos criados e atribuir a cada
        // um seu compontente de layout
        initFormulario();




        //agora so vai chamar a outra tela se o isformok for true e ele sera inicializado como false no initformulario
        //3° Passo: obeter evendo do botao cadastrar
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFormOk = true; //seta true e valida dentro de cada campo

                //4° Passo: validar os dados digitados
                if(TextUtils.isEmpty(editNome.getText().toString())){
                    editNome.setError("Digite seu nome por favor"); //mando o erro
                    editNome.requestFocus(); //manda o foco
                    isFormOk = false; //se ele nao preecheu seta false
                }
                if(TextUtils.isEmpty(editEmail.getText().toString())){
                    editEmail.setError("Digite seu nome por favor"); //mando o erro
                    editEmail.requestFocus(); //manda o foco
                    isFormOk = false; //se ele nao preecheu seta false
                }

                if(TextUtils.isEmpty(editSenhaA.getText().toString())){
                    editSenhaA.setError("Digite seu nome por favor"); //mando o erro
                    editSenhaA.requestFocus(); //manda o foco
                    isFormOk = false; //se ele nao preecheu seta false
                }

                if(TextUtils.isEmpty(editSenhaB.getText().toString())){
                    editSenhaB.setError("Digite seu nome por favor"); //mando o erro
                    editSenhaB.requestFocus(); //manda o foco
                    isFormOk = false; //se ele nao preecheu seta false
                }

                if(!chTermo.isChecked()){
                    isFormOk = false;
                    Toast.makeText(getApplicationContext(), "É necessário aceitar os termos", Toast.LENGTH_LONG).show();
                }


                //5° Passo: depois de tudo ok mudar de tela

                if(isFormOk){ //se for true ele executa e chama a tela
                    //validar senha
                    if(!validarSenha()){ //metodo
                        editSenhaA.setError(("Senhas não conferem")); //alerta
                        editSenhaB.setError(("b")); //alerta
                        editSenhaA.requestFocus(); //vai pro campo A

                        Toast.makeText(getApplicationContext(), "Senhas não conferem", Toast.LENGTH_LONG).show();
                    }else {

                        Intent iMenuPrincipal = new Intent(CadastroUsuarioActivity.this, MainActivity.class);
                        startActivity(iMenuPrincipal);
                    }
                }

            }
        });

    }



    private void initFormulario() {
        //Atribui aos objetos criados o componente de leyout correspondente
        btnCadastro = findViewById(R.id.btnCadastro);
        editNome   = findViewById(R.id.editNome);
        editEmail  = findViewById(R.id.editEmail);
        editSenhaA = findViewById(R.id.editSenha);
        editSenhaB = findViewById(R.id.editSenhaB);
        chTermo    = findViewById(R.id.chTermos);
        isFormOk = false;
    }

    public void validarTermo(View view) {
        if(!chTermo.isChecked()){
            Toast.makeText(getApplicationContext(), "É necessário aceitar os termos", Toast.LENGTH_LONG).show();
        }
    }

    /*Metodo que compara as duas senhas digitadas nos campos*/

    public boolean validarSenha(){ //boleano
        boolean retorno = false; //variavel boleana ja recebendo false

        int senhaA, senhaB;

        senhaA = Integer.parseInt(editSenhaA.getText().toString());
        senhaB = Integer.parseInt(editSenhaB.getText().toString());

        retorno = (senhaA == senhaB);


        return retorno; //reorna o proprio retorno
    }
}
