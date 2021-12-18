package usuario;

import impressao.PedidoImpressao;

import java.util.Objects;
import java.util.Scanner;

public class Aluno extends Usuario{
    private int copiaGratuita;
    private String matricula, curso;

    public Aluno(String nome, String sexo, String dataNascimento, String matricula, String curso) {
        super(nome, sexo, dataNascimento);
        this.copiaGratuita = 50;
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

    public PedidoImpressao pedeImpressao(int arquivo, int numCopias, String cor, String dataEntrega, String horaEntrega) {
        double preco = 0;
        if(!this.verificaQtdCopiaGratuita()) {
            preco = numCopias * 0.25;
        }
        PedidoImpressao pedidoImpressao = new PedidoImpressao(arquivo, numCopias, cor, "Solicitado", dataEntrega, horaEntrega, preco, this);

        return pedidoImpressao;
    }

    public boolean verificaQtdCopiaGratuita() {
        return this.getCopiaGratuita() > 0;
    }

    public void pegar(PedidoImpressao pedidoImpressao) {
        if(pedidoImpressao.getValor() > 0.0) {
            System.out.println("O valor é " + pedidoImpressao.getValor() + ". Confirmar (S/N)?");
            Scanner scanner = new Scanner(System.in);
            String resposta = scanner.nextLine();
            if(Objects.equals(resposta, "N")) {
                return;
            }
        }
        pedidoImpressao.setStatus("Entregue");
    }
}

