package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.SaqueException;
import br.com.banco.desgraca.exception.TipoDeContaException;

import java.text.DecimalFormat;
import java.time.LocalDate;


public class ContaPoupanca extends ContaBancariaPadrao {


    public ContaPoupanca(Integer numeroContaCorrente, InstituicaoBancaria banco, Double saldo) {
        super(numeroContaCorrente, banco, saldo);
        validaBanco(banco);
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
        if (valor < 50){
            throw new SaqueException("Valor indisponível para saque!");
        }
        super.sacar(valor);
        Double taxa = 0.2;
        this.setSaldo(consultarSaldo() - (valor * taxa));
        System.out.println("Foi cobrada uma taxa de serviço no valor de " +
                DecimalFormat.getCurrencyInstance().format(valor * taxa));
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        super.transferir(valor, contaDestino);
        Double taxa = 0.1;
        if (contaDestino.getInstituicaoBancaria().equals(this.getInstituicaoBancaria())) {
            taxa = 0.05;
        }
        this.setSaldo(consultarSaldo() - (valor * taxa));
        System.out.println("Foi cobrada uma taxa de serviço no valor de " +
                DecimalFormat.getCurrencyInstance().format(valor * taxa));
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        super.exibirExtrato(inicio, fim);
    }

    @Override
    public String toString() {
        return "conta poupança " + super.toString();
    }

    @Override
    public void setSaldo(Double saldo) {
        super.setSaldo(saldo);
    }

    private void validaBanco(InstituicaoBancaria banco) {
        if (banco.equals(InstituicaoBancaria.NUBANK)) {
            throw new TipoDeContaException("Não é possível criar este tipo de conta neste banco.");
        }
    }

}
