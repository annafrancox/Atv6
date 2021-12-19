package usuario;

import impressao.PedidoImpressao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public PedidoImpressao pedeImpressao(int arquivo, int numCopias, String cor) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String data = dateFormat.format(cal.getTime());

        dateFormat = new SimpleDateFormat("HH:mm:ss");
        cal = Calendar.getInstance();
        String hour = dateFormat.format(cal.getTime());

        double preco = 0;

        if(numCopias > getCopiaGratuita() || !verificaQtdCopiaGratuita()) {
            preco = (numCopias-getCopiaGratuita()) * 0.25;
        }
        PedidoImpressao pedidoImpressao = new PedidoImpressao(arquivo, numCopias, cor, "Solicitado", preco, this);
        pedidoImpressao.setDataPedido(data);
        pedidoImpressao.setHoraPedido(hour);

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
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String data = dateFormat.format(cal.getTime());

        dateFormat = new SimpleDateFormat("HH:mm:ss");
        cal = Calendar.getInstance();
        String hour = dateFormat.format(cal.getTime());

        if(pedidoImpressao.getValor() > 0.0) {
            System.out.println("O valor é " + pedidoImpressao.getValor() + ". Confirmar (S/N)?");
            Scanner scanner = new Scanner(System.in);
            String resposta = scanner.nextLine();
            if(Objects.equals(resposta, "N")) {
                return false;
            }
        }
        pedidoImpressao.setStatus("Entregue");
        pedidoImpressao.setDataEntrega(data);
        pedidoImpressao.setHoraEntrega(hour);

        return true;
    }
}
