package com.company.domain;

import com.company.exceptions.EditoraException;

public class Editora {
    private String nome;
    private String localização;

    public Editora(String nome, String localização) {
        validaNome(nome);
        this.nome = nome;
        this.localização = localização;
    }

    private void validaNome (String nome){
        if(nome.equals("DC Comics")){
           throw new EditoraException("Esta não!");
        }
    }
}
