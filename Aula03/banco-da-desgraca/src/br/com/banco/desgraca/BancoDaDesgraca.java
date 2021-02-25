package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;

import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

        ContaDigital contaBruno = new ContaDigital(666,InstituicaoBancaria.NUBANK, 100.00);
        ContaDigital contaNeto = new ContaDigital(123,InstituicaoBancaria.ITAU,100.00);
        ContaCorrente contaLucas = new ContaCorrente(159, InstituicaoBancaria.CAIXA, 1000.00);
        ContaPoupanca contaWill = new ContaPoupanca(789, InstituicaoBancaria.BANCO_DO_BRASIL, 500.00);

        contaLucas.transferir(100.00, contaNeto);
        contaLucas.depositar(25.00);
        System.out.println("---------------------");
        contaWill.sacar(60.00);
        contaWill.transferir(123.00, contaLucas);
        System.out.println("---------------------");
        contaBruno.depositar(10.00);
        contaBruno.depositar(15.00);
        contaBruno.sacar(45.00);
        System.out.println("---------------------");
        contaNeto.depositar(120.00);
        contaNeto.sacar(40.00);
        contaNeto.transferir(80.00,contaBruno);
        System.out.println("---------------------");
        contaBruno.exibirExtrato(LocalDate.parse("2020-01-01"),LocalDate.parse("2022-01-01"));
        contaNeto.exibirExtrato(LocalDate.parse("2020-01-01"),LocalDate.parse("2022-01-01"));
        contaLucas.exibirExtrato(LocalDate.parse("2020-01-01"),LocalDate.parse("2022-01-01"));
        contaWill.exibirExtrato(LocalDate.parse("2020-01-01"),LocalDate.parse("2022-01-01"));

        System.out.println(contaBruno.consultarSaldo());
        System.out.println(contaNeto.consultarSaldo());
        System.out.println(contaLucas.consultarSaldo());
        System.out.println(contaWill.consultarSaldo());

    }
}