package br.com.banco.desgraca.exception;

public class TipoDeContaException extends RuntimeException {

    public TipoDeContaException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
