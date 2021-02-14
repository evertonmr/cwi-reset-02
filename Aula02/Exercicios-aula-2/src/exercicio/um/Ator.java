package exercicio.um;

public class Ator extends Pessoa {
    private int quantidadeDeOscars;

    public Ator(String nome, int idade, int quantidadeDeOscars, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeDeOscars = quantidadeDeOscars;
    }

    public void descricao() {
        super.descricao();
        System.out.println("Oscars: " + this.quantidadeDeOscars);
        System.out.println("----------------------");
    }

}
