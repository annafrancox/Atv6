package usuario;

import impressao.PedidoImpressao;
import usuario.Aluno;
import usuario.Professor;
import usuario.Secretario;

public class Secretario extends Funcionario{
    private String horarioTrabalho;

    public static final String credential = "SEC_IMPRESSAO";

    public Secretario(String nome, String sexo, String dataNascimento, String matricula, String unidade, String departamento, String horarioTrabalho) {
        super(nome, sexo, dataNascimento, matricula, unidade, departamento);
        this.horarioTrabalho = horarioTrabalho;
    }

    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    public static Aluno cadastraAluno(String nome, String sexo, String dataNascimento, String matricula, String curso) {
        Aluno aluno = new Aluno(nome, sexo, dataNascimento, matricula, curso);

        return aluno;
    }

    public static Professor cadastraProfessor(String nome, String sexo, String dataNascimento, String matricula, String unidade, String departamento, String horarioAtendimento) {
        Professor professor = new Professor(nome, sexo, dataNascimento, matricula, unidade, departamento, horarioAtendimento);

        return professor;
    }

    public static Secretario cadastraSecretario(String nome, String sexo, String dataNascimento, String matricula, String unidade, String departamento, String horarioTrabalho) {
        Secretario secretario = new Secretario(nome, sexo, dataNascimento, matricula, unidade, departamento, horarioTrabalho);

        return secretario;
    }

    public static void registraImpressao(PedidoImpressao pedido) {
        pedido.setStatus("Fila");
    }

    public static void imprimir(PedidoImpressao pedido) {
        pedido.setStatus("Concluido");
    }
}
