package br.com.banco.desgraca.domain.conta;


import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.SaqueException;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class ContaCorrente extends ContaBancariaPadrao {


    public ContaCorrente(Integer numeroContaCorrente, InstituicaoBancaria banco, Double saldo) {
        super(numeroContaCorrente, banco, saldo);
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return super.getInstituicaoBancaria();
    }

    @Override
    public Double consultarSaldo() {
        return super.consultarSaldo();
    }

    @Override
    public void depositar(Double valor) {
        super.depositar(valor);
    }

    @Override
    public void sacar(Double valor) {
        if ((valor % 5) != 0){
            throw new SaqueException("Não é possível sacar valores que não sejam divisíveis por 5.");
        }
        super.sacar(valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        super.transferir(valor, contaDestino);
        Double taxa = 0.1;
        if (!contaDestino.getInstituicaoBancaria().equals(this.getInstituicaoBancaria())){
            this.setSaldo(consultarSaldo() - (valor * taxa));
            System.out.println("Foi cobrada uma taxa de serviço no valor de " +
                    DecimalFormat.getCurrencyInstance().format(valor * taxa));
        }

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        super.exibirExtrato(inicio, fim);
    }

    @Override
    public String toString() {
        return "conta corrente " + super.toString();
    }

    @Override
    public void setSaldo(Double saldo) {
        super.setSaldo(saldo);
    }

}