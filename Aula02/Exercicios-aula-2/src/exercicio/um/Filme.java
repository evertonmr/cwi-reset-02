package exercicio.um;

public class Filme {
    private String nome;
    private String descricao;
    private int duracao;
    private int avaliacao;
    private Diretor diretor;


    public Filme(String nome, String descricao, int duracao, int avaliacao, Diretor diretor) {
        defineAvaliacao(avaliacao);
        defineAvaliacaoDeAcordoComNome(nome);
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.diretor = diretor;
    }

        public void reproduzir(){
            System.out.println("Reproduzindo o filme: " + this.nome);
            System.out.println("Descrição: " + this.descricao);
            System.out.println("O filme tem duração de " + this.duracao + " minutos");
            System.out.println("Avaliação: " + this.avaliacao + "/5");
            System.out.println("Diretor: " + this.diretor.getNome());
            System.out.println("------------------------------------------");
        }

        private void defineAvaliacao(Integer avaliacao){
            if (avaliacao < 1 || avaliacao > 5){
                this.avaliacao = 3;
            }
            else {
                this.avaliacao = avaliacao;
            }
        }

        private void defineAvaliacaoDeAcordoComNome(String nome){
            if ("O Clube da Luta".equals(nome)){
                this.avaliacao = 5;
            } else if ("Batman vs Superman".equals(nome)){
                this.avaliacao = 1;
            }
        }

}
