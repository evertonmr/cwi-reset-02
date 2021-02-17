public enum UnidadeFederativa {
    ACRE ("Acre", "AC"),
    ALAGOAS ("Alagoas", "AL"),
    AMAPA ("Amapá", "AP"),
    AMAZONAS ("Amazonas", "AM"),
    BAHIA ("Bahia", "BA"),
    CEARA ("Ceará", "CE"),
    ESPIRITO_SANTO ("Espírito Santo", "ES"),
    GOIAS ("Goiás", "GO"),
    MARANHAO ("Maranhão", "MA"),
    MATO_GROSSO ("Mato Grosso", "MT"),
    MATO_GROSSO_DO_SUL ("Mato Grosso do Sul", "MS"),
    MINAS_GERIAS ("Minas Gerias", "MG"),
    PARA ("Pará", "PA"),
    PARAIBA ("Paraíba","PB"),
    PARANA("Paraná","PR"),
    PERNAMBUCO ("Pernambuco", "PE"),
    PIAUI ("Piauí","PI"),
    RIO_DE_JANEIRO ("Rio de Janeiro", "RJ"),
    RIO_GRANDE_DO_SUL ("Rio Grande do Sul", "RS"),
    RONDONIA ("Rondônia", "RO"),
    RORAIMA ("Roraima", "RR"),
    SANTA_CATARINA ("Santa Catarina", "SC"),
    SAO_PAULO ("São Paulo", "SP"),
    SERGIPE ("Sergipe", "SE"),
    TOCANTINS ("Tocantins", "TO");

    private String estado;
    private String sigla;

    UnidadeFederativa(String estado, String sigla) {
        this.estado = estado;
        this.sigla = sigla;
    }

    public String getEstado() {
        return estado;
    }

    public String getSigla() {
        return sigla;
    }
}
