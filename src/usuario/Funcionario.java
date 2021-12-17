package usuario;

public class Funcionario extends Usuario{
    private String matricula, unidade, departamento;

    public Funcionario(int id, String nome, String sexo, String dataNascimento, String matricula, String unidade, String departamento) {
        super(id, nome, sexo, dataNascimento);
        this.matricula = matricula;
        this.unidade = unidade;
        this.departamento = departamento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
