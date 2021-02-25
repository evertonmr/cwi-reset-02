package br.com.banco.desgraca.domain;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Transacao {
    private Double valor;
    private TipoTransacao tipoTransacao;
    private LocalDate dataDaTrasacao;

    public Transacao(Double valor, TipoTransacao tipoTransacao, LocalDate dataDaTrasacao) {
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.dataDaTrasacao = dataDaTrasacao;
    }

    @Override
    public String toString() {
        return tipoTransacao.getDescricao() + " " + DecimalFormat.getCurrencyInstance().format(valor) + " " + dataDaTrasacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

}
