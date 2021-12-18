package usuario;

import impressao.PedidoImpressao;

import java.util.Objects;
import java.util.Scanner;

public class Professor extends Funcionario{
    private String horarioAtendimento;
    private int copiaGratuita;

    public Professor(String nome, String sexo, String dataNascimento, String matricula, String unidade, String departamento, String horarioAtendimento) {
        super(nome, sexo, dataNascimento, matricula, unidade, departamento);
        this.horarioAtendimento = horarioAtendimento;
        this.copiaGratuita = 200;
    }

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public int getCopiaGratuita() {
        return copiaGratuita;
    }

    public PedidoImpressao pedeImpressao(int arquivo, int numCopias, String cor, String dataEntrega, String horaEntrega) {
        double preco = 0;

        if(numCopias > getCopiaGratuita() || !verificaQtdCopiaGratuita()) {
            preco = (numCopias-getCopiaGratuita()) * 0.25;
        }
        PedidoImpressao pedidoImpressao = new PedidoImpressao(arquivo, numCopias, cor, "Solicitado", dataEntrega, horaEntrega, preco, this);
        this.copiaGratuita -= numCopias;
        if(this.copiaGratuita < 0) {
            setCopiaGratuita(0);
        }

        return pedidoImpressao;
    }

    public void setCopiaGratuita(int copiaGratuita) {
        this.copiaGratuita = copiaGratuita;
    }

    public boolean verificaQtdCopiaGratuita() {
        return this.getCopiaGratuita() > 0;
    }

    public boolean pegar(PedidoImpressao pedidoImpressao) {
        if(pedidoImpressao.getValor() > 0.0) {
            System.out.println("O valor é " + pedidoImpressao.getValor() + ". Confirmar (S/N)?");
            Scanner scanner = new Scanner(System.in);
            String resposta = scanner.nextLine();
            if(Objects.equals(resposta, "N")) {
                return false;
            }
        }
        pedidoImpressao.setStatus("Entregue");
        return true;
    }
}
