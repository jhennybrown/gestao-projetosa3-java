package br.gestao.projetosa3;

public class Usuario {
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String cargo; // administrador, gerente, colaborador
    private String login;
    private String senha;

    public Usuario(String nomeCompleto, String cpf, String email, String cargo, String login, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Usuário: " + nomeCompleto + " | Cargo: " + cargo + " | E-mail: " + email;
    }
}
