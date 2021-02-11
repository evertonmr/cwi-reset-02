public class Aplicacao {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        int subtracao = calculadora.subtracao(9, 4);
        System.out.println(subtracao);

        int soma = calculadora.soma(1, 5);
        System.out.println(soma);

        float divisao = calculadora.divide(4, 2);
        System.out.println(divisao);

        float multplicacao = calculadora.multplica(7, 7);
        System.out.println(multplicacao);

    }
}
