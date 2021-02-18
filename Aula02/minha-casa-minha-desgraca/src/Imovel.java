public abstract class Imovel {
    private Double valor;
    private Endereco endereco;

    public Imovel(Double valor, Endereco endereco) {
        this.valor = valor;
        this.endereco = endereco;
    }


    public String apresentacao() {
        return this.endereco.descreverEnderecoCompleto() + ". Valor: R$" + getValor();
    }
    public Double getValor(){
        return this.valor;
    }

    public Endereco getEndereco(){
        return this.endereco;
    }

}
