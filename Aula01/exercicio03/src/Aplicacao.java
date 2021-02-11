public class Aplicacao {

    public static void main(String[] args) {

        String nomeAluno = "Everton";
        double nota1 = 7;
        double nota2 = 8;
        Aluno aluno = new Aluno(nomeAluno, nota1, nota2);

        System.out.println(aluno.getNome());
        System.out.println(aluno.getMedia());
        System.out.println(aluno.getAprovacao());

    }

}
