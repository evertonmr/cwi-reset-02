public class PropostaFinanciamento {
    private Beneficiario beneficiario;
    private Imovel imovelEscolhido;
    private int mesesParaPagamento;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovelEscolhido, int mesesParaPagamento) {
        this.beneficiario = beneficiario;
        this.imovelEscolhido = imovelEscolhido;
        this.mesesParaPagamento = mesesParaPagamento;
    }

    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */
    public void validarProposta() throws InterruptedException {
        Double salarioEstendido = (this.beneficiario.getSalario() * this.mesesParaPagamento);
        Double porcentagemDoImovel = 0.5;

//        Exeções à regra:
        if (this.imovelEscolhido.getEndereco().getEstado().getSigla().equals("SP")){
            porcentagemDoImovel = 0.65;
        } else if (this.imovelEscolhido.getEndereco().getEstado().getSigla().equals("RJ")) {
            porcentagemDoImovel = 0.6;
        }

        Boolean regra = salarioEstendido >= (this.imovelEscolhido.getValor() * porcentagemDoImovel);

        if (regra){
            imprimirPropostaAprovada();
        } else {
            imprimirPropostaNegada();
        }
    }


    private void imprimirPropostaAprovada() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println( "Imóvel escolhido: " + imovelEscolhido.apresentacao());
        Thread.sleep(5000);
        System.out.println("Financiamento aprovado! Parabéns " + beneficiario.getNome() + "!" + " Agora você tem uma dívida de " + mesesParaPagamento + " meses!");

    }

    private void imprimirPropostaNegada() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Imóvel escolhido: " + imovelEscolhido.apresentacao());
        Thread.sleep(5000);
        System.out.println(beneficiario.getNome() + ", achou que seu financiamento de R$" + imovelEscolhido.getValor() +
                " em " + mesesParaPagamento + " meses, seria aprovado?");
        Thread.sleep(5000);
        System.out.println("Achou errado! Seu financioamento foi negado!");

    }
}