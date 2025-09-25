package br.gestao.projetosa3;

import java.util.Date;

public class Projeto {
    private String nome;
    private String descricao;
    private Date dataInicio;
    private Date dataTerminoPrevista;
    private String status; // planejado, em andamento, concluído, cancelado
    private Usuario gerenteResponsavel;

    public Projeto(String nome, String descricao, Date dataInicio, Date dataTerminoPrevista, String status, Usuario gerenteResponsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTerminoPrevista = dataTerminoPrevista;
        this.status = status;
        this.gerenteResponsavel = gerenteResponsavel;
    }

    @Override
    public String toString() {
        return "Projeto: " + nome + " | Status: " + status + " | Gerente: " + gerenteResponsavel.getNomeCompleto();
    }
}