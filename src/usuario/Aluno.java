package usuario;

public class Aluno extends Usuario{
    private int copiaGratuita;
    private String matricula, curso;

    public Aluno(int id, String nome, String sexo, String dataNascimento, int copiaGratuita, String matricula, String curso) {
        super(id, nome, sexo, dataNascimento);
        this.copiaGratuita = copiaGratuita;
        this.matricula = matricula;
        this.curso = curso;
    }

    public int getCopiaGratuita() {
        return copiaGratuita;
    }

    public void setCopiaGratuita(int copiaGratuita) {
        this.copiaGratuita = copiaGratuita;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}

