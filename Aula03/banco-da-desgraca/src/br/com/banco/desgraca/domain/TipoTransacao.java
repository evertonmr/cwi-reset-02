package br.com.banco.desgraca.domain;

import java.security.SecureRandom;

public enum TipoTransacao {
    SOMA ("+"),
    SUBTRAI ("-");

    private String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}