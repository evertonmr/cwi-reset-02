package br.com.banco.desgraca.domain.conta;


import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.SaqueException;


public class ContaCorrente extends ContaBancariaPadrao {


    public ContaCorrente(Integer numeroContaCorrente, InstituicaoBancaria banco, Double saldo) {
        super(numeroContaCorrente, banco, saldo);
    }

    @Override
    protected void validaBanco(InstituicaoBancaria banco) {
    }

    @Override
    protected Double calculaTaxaSaque(Double valor) {
        return 0.0;
    }

    @Override
    protected void validaSaque(Double valor) {
        if ((valor % 5) != 0) {
            throw new SaqueException("Não é possível sacar valores que não sejam divisíveis por 5.");
        }
    }

    @Override
    protected Double calcularTaxaDeTransferencia(Double valor, ContaBancaria contaDestino) {
        Double taxa = 0.0;
        if (!contaDestino.getInstituicaoBancaria().equals(this.getInstituicaoBancaria())) {
            taxa = 0.01;
        }
        Double valorTaxa = valor * taxa;
        return valorTaxa;
    }

    @Override
    public String toString() {
        return "conta corrente " + super.toString();
    }

}