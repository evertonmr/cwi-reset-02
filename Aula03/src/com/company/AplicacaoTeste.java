package com.company;

import com.company.domain.Editora;
import com.company.domain.Filme;
import com.company.enumerador.Genero;
import com.company.heranca.Diretor;

public class AplicacaoTeste {
    public static void main(String[] args) {
        Editora novaEditora = new Editora("Marvel", "Algum lugar");
//      Editora outraEditora = new Editora("DC Comics", "Por aí");

        Filme novoFilme = new Filme("Teste", "Descrção", 120, 1994, 4, new Diretor("Diretor", 55, 1, Genero.MASCULINO));

    }
}
