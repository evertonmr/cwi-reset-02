package exercicio.um;

public class Diretor extends Pessoa{
    private int quantidadeFilmesDirigidos;

    public Diretor(String nome, int idade, int quantidadeFilmesDirigidos, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeFilmesDirigidos = quantidadeFilmesDirigidos;
    }

    public void descricao() {
        super.descricao();
        System.out.println("Quantidade de filmes dirigidos: " + quantidadeFilmesDirigidos);
        System.out.println("----------------------");
    }

}