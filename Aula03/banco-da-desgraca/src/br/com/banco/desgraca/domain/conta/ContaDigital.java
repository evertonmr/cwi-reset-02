package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.SaqueException;
import br.com.banco.desgraca.exception.TipoDeContaException;

public class ContaDigital extends ContaBancariaPadrao{

    public ContaDigital(Integer numeroContaCorrente, InstituicaoBancaria banco, Double saldo) {
        super(numeroContaCorrente, banco, saldo);
        validaBanco(banco);
    }
    @Override
    protected void validaBanco(InstituicaoBancaria banco) {
        if (!banco.equals(InstituicaoBancaria.ITAU) && !banco.equals(InstituicaoBancaria.NUBANK)) {
            throw new TipoDeContaException("Não é possível criar este tipo de conta neste banco.");
        }
    }

    @Override
    protected Double calculaTaxaSaque(Double valor) {
        return 0.0;
    }

    @Override
    protected void validaSaque(Double valor) {
        if (valor < 10) {
            throw new SaqueException("Valor indisponível para saque!.");
        }
    }

    @Override
    protected Double calcularTaxaDeTransferencia(Double valor, ContaBancaria contaDestino) {
        return 0.0;
    }

    @Override
    public String toString() {
        return "conta digital " + super.toString();
    }

}
