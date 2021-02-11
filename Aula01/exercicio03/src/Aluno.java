public class Aluno {

        private String nome;

        private double nota1;

        private double nota2;

        private double media;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNome() {
        return nome;
        }

    public double getMedia() {
        media = (nota1 + nota2) / 2;
        return media;
    }

    public boolean getAprovacao() {
        return (media >= 7.0);
        }
}
