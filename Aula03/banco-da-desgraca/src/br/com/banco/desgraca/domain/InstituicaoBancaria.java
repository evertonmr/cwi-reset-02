package br.com.banco.desgraca.domain;

public enum InstituicaoBancaria {
    BANCO_DO_BRASIL ("Banco do Brasil"),
    BRADESCO ("Bradesco"),
    CAIXA ("CAIXA"),
    ITAU ("Itaú"),
    NUBANK ("NuBank");

    private String nomeBanco;

    InstituicaoBancaria(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }
}