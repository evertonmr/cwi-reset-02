package exercicio.um;

import java.time.LocalDate;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        // Criação de Diretores
        Diretor peterJackson = new Diretor(
                "Peter Jackson",
                LocalDate.parse("1961-10-31"),
                Genero.MASCULINO,
                17);

        Diretor davidFincher = new Diretor(
                "David Fincher",
                LocalDate.parse("1962-08-28"),
                Genero.MASCULINO,
                11);
        
        // Criação de atores
        Ator ianMcKellen = new Ator(
                "Ian McKellen",
                LocalDate.parse("1939-05-25"),
                Genero.NAO_BINARIO,
                0);

        Ator elijahWood = new Ator(
                "Elijah Jordan Wood",
                LocalDate.parse("1981-01-28"),
                Genero.MASCULINO,
                0);

        Ator bradPitt = new Ator(
                "William Bradley Pitt",
                LocalDate.parse("1963-12-18"),
                Genero.MASCULINO,
                2);

        // Criação de filmes
        Filme oSenhorDosAneisUm = new Filme(
                "O Senhor dos Aneis: A Sociedade do Anel",
                "Melhor filme de todos",
                999,
                5,
                peterJackson, List.of(peterJackson ,elijahWood, ianMcKellen));

        Filme oSenhorDosAneisDois = new Filme(
                "O Senhor dos Aneis: As Duas Torres",
                "Melhor filme de todos",
                999,
                5,
                peterJackson, List.of(peterJackson ,elijahWood, ianMcKellen));

        Filme oClubeDaLuta = new Filme(
                "O Clube da Luta",
                """
                        Um homem deprimido que sofre de insônia conhece um estranho vendedor chamado
                        Tyler Durden e se vê morando em uma casa suja depois que seu perfeito apartamento é destruído.
                        A dupla forma um clube com regras rígidas onde homens lutam. A parceria perfeita é comprometida
                        quando uma mulher, Marla, atrai a atenção de Tyler.""",
                139,
                4,
                davidFincher, List.of(davidFincher , bradPitt)) ;

        System.out.println("------------------------------------------");
        // Execução de filmes
        oSenhorDosAneisUm.reproduzir();
        oSenhorDosAneisDois.reproduzir();
        oClubeDaLuta.reproduzir();

        // Execução da descrição de atores e diretores
        ianMcKellen.descricao();
        peterJackson.descricao();
        davidFincher.descricao();

        oClubeDaLuta.exibirCreditos();
    }
}
