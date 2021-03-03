package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

abstract class ContaBancariaPadrao implements ContaBancaria {
    private Integer numeroContaCorrente;
    private InstituicaoBancaria banco;
    private Double saldo;
    private List<Transacao> transacoes;
    private LocalDate dataDatransacao;

    ContaBancariaPadrao(Integer numeroContaCorrente, InstituicaoBancaria banco, Double saldo) {
        validaBanco(banco);
        this.numeroContaCorrente = numeroContaCorrente;
        this.banco = banco;
        this.saldo = saldo;
        this.dataDatransacao = null;
        transacoes = new ArrayList<>();
    }

    protected  abstract void validaBanco(InstituicaoBancaria banco);

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
        Double taxaDeposito = 0.0;

        registraTrasacao(valor, TipoTransacao.SOMA, taxaDeposito);

        System.out.println("Deposito no valor de " + DecimalFormat.getCurrencyInstance().format(valor) +
                " na " + this.toString() + " realizado com sucesso!");
    }

    @Override
    public void sacar(Double valor) {

        validaSaque(valor);

        Double taxa = calculaTaxaSaque(valor);

        debita(valor, taxa);

        System.out.println("Saque no valor de " + DecimalFormat.getCurrencyInstance().format(valor) +
                    " da " + this.toString() + " realizado com sucesso!");

    }

    protected abstract Double calculaTaxaSaque(Double valor);

    protected abstract void validaSaque(Double valor);

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        
        Double taxa = calcularTaxaDeTransferencia(valor, contaDestino);
        
        debita(valor, taxa);

        contaDestino.recebeTransferencia(valor, this.dataDatransacao);

        System.out.println("Transferência no valor de " + DecimalFormat.getCurrencyInstance().format(valor) +
                " para a conta " + contaDestino + " realizada com sucesso!");
        if (taxa > 0) {
            System.out.println("Foi cobrada uma taxa de serviço no valor de " +
                    DecimalFormat.getCurrencyInstance().format(taxa));
        }
    }

    protected abstract Double calcularTaxaDeTransferencia(Double valor, ContaBancaria contaDestino);

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        System.out.println("-------- EXTRATO " + this.toString().toUpperCase() + " --------");

        for (Transacao transacao : trasacoesOrdenadasPorDataDecrescente()) {

            boolean filtroInicial = (inicio == null || transacao.getData().isAfter(inicio));
            boolean filtroFinal = (fim == null || transacao.getData().isBefore(fim));

            if (filtroInicial && filtroFinal) {
                System.out.println(transacao);
            }
        }
        System.out.println("-------------------------------------------------");

    }

    protected void debita(Double valor, Double valorTaxa) {
        if (this.saldo >= (valor + valorTaxa)) {
            this.saldo -= (valor + valorTaxa);

            registraTrasacao(valor, TipoTransacao.SUBTRAI, valorTaxa);

        } else {throw new SaldoInsuficienteException("Saldo insuficiente.");}
    }


    public void recebeTransferencia(Double valor, LocalDate dataDaTransferencia){
        Double taxaTransferenciaRecebida = 0.0;
        saldo += valor;

        registraTrasacao(valor, TipoTransacao.SOMA, taxaTransferenciaRecebida).setDataDaTrasacao(dataDaTransferencia);

    }

    protected Transacao registraTrasacao(Double valor, TipoTransacao tipo, Double taxa) {
        Transacao novaTransacao = new Transacao(valor, tipo, taxa);
        transacoes.add(novaTransacao);
        dataDatransacao = novaTransacao.getData();
        return novaTransacao;
    }

    @Override
    public String toString() {
        return numeroContaCorrente + " " + banco.getNomeBanco();
    }

    private List<Transacao> trasacoesOrdenadasPorDataDecrescente() {

        List<Transacao> transacaosOrdenadas = new ArrayList<>(transacoes);

        Collections.sort(transacaosOrdenadas, new Comparator<Transacao>() {
            @Override
            public int compare(Transacao o1, Transacao o2) {
                return o2.getData().compareTo(o1.getData());
            }
        });

        return transacaosOrdenadas;
    }

}

