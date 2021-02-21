package exercicio.um;
import java.time.LocalDate;
import java.time.Period;


public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;



    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    private Integer Idade(){
        Integer idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        return idade;
    }

    public void descricao() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + Idade());
        System.out.println("Genero: " + genero.getDescricao());
    }

    public String getNome() {
        return nome;
    }
}
