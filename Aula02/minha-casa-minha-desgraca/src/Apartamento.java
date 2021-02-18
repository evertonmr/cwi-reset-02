public class Apartamento extends Imovel {
    private int andar;

    public Apartamento(Double valor, Endereco endereco, int andar) {
        super(valor, endereco);
        this.andar = andar;
    }

    public int getAndar() {
        return andar;
    }

    public String apresentacao() {
        return "Apartamento no " + getAndar() + "º andar, localizado em " + super.apresentacao();

    }
}
