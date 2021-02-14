public class Aplicacao {

    public static void main(String[] args) {

        String nomeAluno = "Everton";
        double nota1 = 8;
        double nota2 = 0;
        Aluno aluno = new Aluno(nomeAluno, nota1, nota2);

        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Nota final: " + aluno.getNotaFinal());
        System.out.println("O aluno foi " + (aluno.getAprovacao() ? "Aprovado" : "Reprovado"));

    }

}
