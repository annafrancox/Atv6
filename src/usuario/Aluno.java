package usuario;

import impressao.PedidoImpressao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

