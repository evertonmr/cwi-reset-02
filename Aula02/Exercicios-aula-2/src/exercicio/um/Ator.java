package exercicio.um;

import java.time.LocalDate;

public class Ator extends Pessoa {
    private int quantidadeDeOscars;

    public Ator(String nome, LocalDate dataNascimento, Genero genero, int quantidadeDeOscars) {
        super(nome, dataNascimento, genero);
        this.quantidadeDeOscars = quantidadeDeOscars;
    }

    public void descricao() {
        super.descricao();
        System.out.println("Oscars: " + this.quantidadeDeOscars);
        System.out.println("----------------------");
    }

}
