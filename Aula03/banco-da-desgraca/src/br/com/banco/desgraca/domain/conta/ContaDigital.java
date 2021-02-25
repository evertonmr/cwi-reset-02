package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.exception.SaqueException;
import br.com.banco.desgraca.exception.TipoDeContaException;

import java.time.LocalDate;


public class ContaDigital extends ContaBancariaPadrao{

    public ContaDigital(Integer numeroContaCorrente, InstituicaoBancaria banco, Double saldo) {
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
        if (valor < 10){
            throw new SaqueException("Valor indisponível para saque!");
        }
        super.sacar(valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        super.transferir(valor, contaDestino);
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        super.exibirExtrato(inicio, fim);
    }

    private void validaBanco(InstituicaoBancaria banco) {
        if (!banco.equals(InstituicaoBancaria.ITAU) && !banco.equals(InstituicaoBancaria.NUBANK)) {
            throw new TipoDeContaException("Não é possível criar este tipo de conta neste banco.");
        }
    }

    public String toString() {
        return "conta digital " + super.toString();
    }

    @Override
    public void setSaldo(Double saldo) {
        super.setSaldo(saldo);
    }
}
