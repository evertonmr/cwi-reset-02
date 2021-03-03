package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.SaqueException;
import br.com.banco.desgraca.exception.TipoDeContaException;

public class ContaPoupanca extends ContaBancariaPadrao {

    public ContaPoupanca(Integer numeroContaCorrente, InstituicaoBancaria banco, Double saldo) {
        super(numeroContaCorrente, banco, saldo);
        validaBanco(banco);
    }
    @Override
    protected void validaBanco(InstituicaoBancaria banco) {
        if (banco.equals(InstituicaoBancaria.NUBANK)) {
            throw new TipoDeContaException("Não é possível criar este tipo de conta neste banco.");
        }
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return super.getInstituicaoBancaria();
    }


    @Override
    protected Double calculaTaxaSaque(Double valor) {
        Double taxa = 0.02;
        Double valorTaxa = taxa * valor;
        return valorTaxa;
    }

    @Override
    protected void validaSaque(Double valor) {
        if (valor < 50) {
            throw new SaqueException("Valor indisponível para saque!");
        }
    }

    @Override
    protected Double calcularTaxaDeTransferencia(Double valor, ContaBancaria contaDestino) {
        Double taxa = 0.005;
        if (!contaDestino.getInstituicaoBancaria().equals(this.getInstituicaoBancaria())) {
            taxa = 0.01;
        }
        Double valorTaxa = valor * taxa;
        return valorTaxa;
    }

    @Override
    public String toString() {
        return "conta poupança " + super.toString();
    }

}