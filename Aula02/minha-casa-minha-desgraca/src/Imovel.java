public class Imovel {
    private Double valor;
    private Endereco endereco;

    public Imovel(Double valor, Endereco endereco) {
        this.valor = valor;
        this.endereco = endereco;
    }


    public String apresentacao(){
        return "Imovel localizado em " + this.endereco.descreverEnderecoCompleto() +
                ". Valor: R$" + getValor();
    }
    public Double getValor() {
        return valor;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

}
