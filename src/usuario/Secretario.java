package usuario;

public class Secretario extends Funcionario{
    private String horarioTrabalho;

    public Secretario(int id, String nome, String sexo, String dataNascimento, String matricula, String unidade, String departamento, String horarioTrabalho) {
        super(id, nome, sexo, dataNascimento, matricula, unidade, departamento);
        this.horarioTrabalho = horarioTrabalho;
    }

    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }
}
