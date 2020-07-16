/**SuperClasse que deriva as outras */
package app.daazi.v1.appclientevip.model;

public class Cliente {
    //atributos
    private int id;
    private String primeiroNome;
    private String sobrenomeNome;
    private String email;
    private String senha;
    private boolean pessoaFisica; //se eh pf ou nao

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenomeNome() {
        return sobrenomeNome;
    }

    public void setSobrenomeNome(String sobrenomeNome) {
        this.sobrenomeNome = sobrenomeNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(boolean pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
}
