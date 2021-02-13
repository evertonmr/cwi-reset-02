package exercicio.um;

public class Filme {
    private String nome;
    private String descricao;
    private int duracao;
    private int avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, int duracao, int avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzir(){
        System.out.println("Reproduzindo o filme: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("O filme tem duração de " + this.duracao + " minutos");
        System.out.println("Diretor: " + this.diretor.getNome());
        System.out.println("------------------------------------------");
    }

}
