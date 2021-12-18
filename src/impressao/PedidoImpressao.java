package impressao;

import usuario.Usuario;

public class PedidoImpressao {
    private int id, arquivo, numCopias;
    private String data, hora, cor, status, dataEntrega, horaEntrega;
    private double valor;
    private Usuario solicitante;

    public PedidoImpressao(int arquivo, int numCopias, String data, String hora, String cor, String status, String dataEntrega, String horaEntrega, double valor, Usuario solicitante) {
        this.id = 1;
        this.arquivo = arquivo;
        this.numCopias = numCopias;
        this.data = data;
        this.hora = hora;
        this.cor = cor;
        this.status = status;
        this.dataEntrega = dataEntrega;
        this.horaEntrega = horaEntrega;
        this.valor = valor;
        this.solicitante = solicitante;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    @Override
    public String toString() {
        return "PedidoImpressao{" +
                "id=" + id +
                ", arquivo=" + arquivo +
                ", numCopias=" + numCopias +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", cor='" + cor + '\'' +
                ", dataEntrega='" + dataEntrega + '\'' +
                ", horaEntrega='" + horaEntrega + '\'' +
                ", valor=" + valor +
                '}';
    }
}
