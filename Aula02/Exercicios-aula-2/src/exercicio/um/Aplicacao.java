package exercicio.um;

public class Aplicacao {

    public static void main(String[] args) {
        Diretor peterJackson = new Diretor("Peter Jackson", 59, 17);

        Filme oSenhorDosAneisUm = new Filme("O Senhor dos Aneis: A Sociedade do Anel", "Melhor filme de todos", 999, 5, peterJackson);
        Filme oSenhorDosAneisDois = new Filme("O Senhor dos Aneis: As Duas Torres", "Melhor filme de todos", 999, 5, peterJackson);

        oSenhorDosAneisUm.reproduzir();
        oSenhorDosAneisDois.reproduzir();

    }
}
