package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.Data;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Transacao {
    private Double valor;
    private TipoTransacao tipoTransacao;
    private Double taxa;
    private LocalDate dataDaTrasacao;
    
    
    public Transacao(Double valor, TipoTransacao tipoTransacao, Double taxa) {
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.taxa = taxa;
        this.dataDaTrasacao = Data.getDataTransacao();
    }

    @Override
    public String toString() {
        return String.format("%s %12s   - %9s %12s",
                tipoTransacao.getDescricao(),
                DecimalFormat.getCurrencyInstance().format(valor),
                DecimalFormat.getCurrencyInstance().format(taxa),
                dataDaTrasacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    public LocalDate getData() {
        return dataDaTrasacao;
    }

    public void setDataDaTrasacao(LocalDate dataDaTrasacao) {
        this.dataDaTrasacao = dataDaTrasacao;
    }
}
