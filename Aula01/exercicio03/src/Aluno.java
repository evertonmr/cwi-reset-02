public class Aluno {

        private String nome;
        private double notaFinal;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.notaFinal = (nota1 + nota2) / 2;
    }

    public String getNome() {
        return nome;
        }

    public double getNotaFinal() {
        return notaFinal;
    }

    public boolean getAprovacao() {
        return (notaFinal >= 7.0);
        }

}
