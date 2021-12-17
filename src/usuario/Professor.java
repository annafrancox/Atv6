package usuario;

public class Professor extends Funcionario{
    private String disciplinas, horarioAtendimento,copiaGratuita;

    public Professor(int id, String nome, String sexo, String dataNascimento, String matricula, String unidade, String departamento, String disciplinas, String horarioAtendimento, String copiaGratuita) {
        super(id, nome, sexo, dataNascimento, matricula, unidade, departamento);
        this.disciplinas = disciplinas;
        this.horarioAtendimento = horarioAtendimento;
        this.copiaGratuita = copiaGratuita;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public String getCopiaGratuita() {
        return copiaGratuita;
    }

    public void setCopiaGratuita(String copiaGratuita) {
        this.copiaGratuita = copiaGratuita;
    }
}
