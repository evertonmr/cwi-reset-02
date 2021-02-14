package exercicio.um;

public enum Genero {
    MASCOLINO ("Masculino"),
    FEMININO ("Feminino"),
    NAO_BINARIO ("Não Binário");

    private String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
