package exercicio.um;

import java.time.LocalDate;

public class Diretor extends Pessoa{
    private int quantidadeFilmesDirigidos;

    public Diretor(String nome, LocalDate dataNascimento, Genero genero, int quantidadeFilmesDirigidos) {
        super(nome, dataNascimento, genero);
        this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
    }


    public void descricao() {
        super.descricao();
        System.out.println("Quantidade de filmes dirigidos: " + quantidadeFilmesDirigidos);
        System.out.println("----------------------");
    }

}