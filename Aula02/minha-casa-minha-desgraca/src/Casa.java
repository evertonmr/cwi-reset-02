public class Casa extends Imovel {
    private Boolean patio;

    public Casa(Double valor, Endereco endereco, Boolean patio) {
        super(valor, endereco);
        this.patio = patio;
    }

    public Boolean getPatio() {
        return patio;
    }

    public String apresentacao() {
        return "Casa " + (patio ? "com" : "sem") + " pátio localizada em " + super.apresentacao();
    }

}
