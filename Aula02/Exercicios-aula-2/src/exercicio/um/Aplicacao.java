package exercicio.um;

public class Aplicacao {

    public static void main(String[] args) {
        // Criação de Diretores
        Diretor peterJackson = new Diretor(
                "Peter Jackson",
                59,
                17,
                Genero.MASCULINO);

        Diretor davidFincher = new Diretor(
                "David Fincher",
                58,
                11,
                Genero.MASCULINO);


        // Criação de atores
        Ator ianMcKellen = new Ator(
                "Ian McKellen",
                81,
                0,
                Genero.NAO_BINARIO);


        // Criação de filmes
        Filme oSenhorDosAneisUm = new Filme(
                "O Senhor dos Aneis: A Sociedade do Anel",
                "Melhor filme de todos",
                999,
                5,
                peterJackson);

        Filme oSenhorDosAneisDois = new Filme(
                "O Senhor dos Aneis: As Duas Torres",
                "Melhor filme de todos",
                999,
                5,
                peterJackson);

        Filme oClubeDaLuta = new Filme(
                "O Clube da Luta",
                """
                        Um homem deprimido que sofre de insônia conhece um estranho vendedor chamado
                        Tyler Durden e se vê morando em uma casa suja depois que seu perfeito apartamento é destruído.
                        A dupla forma um clube com regras rígidas onde homens lutam. A parceria perfeita é comprometida
                        quando uma mulher, Marla, atrai a atenção de Tyler.""",
                139,
                4,
                davidFincher);

        System.out.println("------------------------------------------");
        // Execução de filmes
        oSenhorDosAneisUm.reproduzir();
        oSenhorDosAneisDois.reproduzir();
        oClubeDaLuta.reproduzir();

        // Execução da descrição de atores e diretores
        ianMcKellen.descricao();
        peterJackson.descricao();
        davidFincher.descricao();
    }
}
