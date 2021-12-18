package impressao;

import usuario.Aluno;
import usuario.Professor;
import usuario.Usuario;

public class PedidoImpressao {
    private static int auxId;
    private int id, arquivo, numCopias;
    private String cor, status, dataEntrega, horaEntrega;
    private double valor;
    private Professor solicitanteProfessor;
    private Aluno solicitanteAluno;

    public PedidoImpressao(int arquivo, int numCopias, String cor, String status, String dataEntrega, String horaEntrega, double valor, Professor solicitanteProfessor) {
        auxId++;
        this.id = auxId;
        this.arquivo = arquivo;
        this.numCopias = numCopias;
        this.cor = cor;
        this.status = status;
        this.dataEntrega = dataEntrega;
        this.horaEntrega = horaEntrega;
        this.valor = valor;
        this.solicitanteProfessor = solicitanteProfessor;
    }

    public PedidoImpressao(int arquivo, int numCopias, String cor, String status, String dataEntrega, String horaEntrega, double valor, Aluno solicitanteAluno) {
        auxId++;
        this.id = auxId;
        this.arquivo = arquivo;
        this.numCopias = numCopias;
        this.cor = cor;
        this.status = status;
        this.dataEntrega = dataEntrega;
        this.horaEntrega = horaEntrega;
        this.valor = valor;
        this.solicitanteAluno = solicitanteAluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArquivo() {
        return arquivo;
    }

    public void setArquivo(int arquivo) {
        this.arquivo = arquivo;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        this.numCopias = numCopias;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Usuario getSolicitanteProfessor() {
        return solicitanteProfessor;
    }

    public void setSolicitanteProfessor(Professor solicitante) {
        this.solicitanteProfessor = solicitante;
    }

    public Aluno getSolicitanteAluno() {
        return solicitanteAluno;
    }

    public void setSolicitanteAluno(Aluno solicitanteAluno) {
        this.solicitanteAluno = solicitanteAluno;
    }

    @Override
    public String toString() {
        return "PedidoImpressao{" +
                "id=" + id +
                ", arquivo=" + arquivo +
                ", numCopias=" + numCopias +
                ", cor='" + cor + '\'' +
                ", dataEntrega='" + dataEntrega + '\'' +
                ", horaEntrega='" + horaEntrega + '\'' +
                ", valor=" + valor +
                '}';
    }
}
