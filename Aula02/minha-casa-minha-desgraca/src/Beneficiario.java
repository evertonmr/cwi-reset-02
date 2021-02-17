public class Beneficiario {
    private String nomeBeneficiario;
    private double salarioBeneficiario;

    public Beneficiario(String nomeBeneficiario, double salarioBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
        this.salarioBeneficiario = salarioBeneficiario;
    }

    public String getNome() {
        return nomeBeneficiario;
    }

    public double getSalario() {
        return salarioBeneficiario;
    }
}
