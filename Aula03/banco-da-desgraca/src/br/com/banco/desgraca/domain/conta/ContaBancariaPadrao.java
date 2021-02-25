package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContaBancariaPadrao implements ContaBancaria {
    private Integer numeroContaCorrente;
    private InstituicaoBancaria banco;
    private Double saldo;
    private List<Transacao> transacaos;

    public ContaBancariaPadrao(Integer numeroContaCorrente, InstituicaoBancaria banco, Double saldo) {
        this.numeroContaCorrente = numeroContaCorrente;
        this.banco = banco;
        this.saldo = saldo;
        transacaos = new ArrayList<>();
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return this.banco;
    }

    @Override
    public Double consultarSaldo() {
        return this.saldo;
    }

    @Override
    public void depositar(Double valor) {
        this.saldo += valor;
        transacaos.add(new Transacao(valor, TipoTransacao.SOMA, Data.getDataTransacao()));
        System.out.println("Deposito no valor de " + DecimalFormat.getCurrencyInstance().format(valor) +
                " na " + this.toString() + " realizado com sucesso!");
    }

    @Override
    public void sacar(Double valor) {
        if (this.saldo >= valor){
            this.saldo -= valor;
            transacaos.add(new Transacao(valor, TipoTransacao.SUBTRAI, Data.getDataTransacao()));
            System.out.println("Saque no valor de " + DecimalFormat.getCurrencyInstance().format(valor) +
                    " da " + this.toString() + " realizado com sucesso!");
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        if (this.saldo >= valor){
            this.saldo -= valor;
            transacaos.add(new Transacao(valor, TipoTransacao.SUBTRAI, Data.getDataTransacao()));
            System.out.println("Transferência no valor de " + DecimalFormat.getCurrencyInstance().format(valor) +
                    " da " + this.toString() + " para a " + contaDestino.toString() + " realizado com sucesso!");
            // A data do deposito vai ser sempre 5 dias depois da transferencia. Estou considerando que seja assim mesmo.
            contaDestino.depositar(valor);

        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        System.out.println("-------- EXTRATO " + this.toString().toUpperCase(Locale.ROOT) + " --------");
        for (Transacao transacao : transacaos) {
            System.out.println(transacao);
        }
        System.out.println("-------------------------------------------------");
    }

    @Override
    public String toString() {
        return numeroContaCorrente + " " + banco.getNomeBanco();
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}

