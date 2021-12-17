package impressao;

public class PedidoImpressao {
    private int id, arquivo, numCopias;
    private String data, hora, cor, status, dataEntrega, horaEntrega;
    private float valor;

    public PedidoImpressao(int id, int arquivo, int numCopias, String data, String hora, String cor, String status, String dataEntrega, String horaEntrega, float valor) {
        this.id = id;
        this.arquivo = arquivo;
        this.numCopias = numCopias;
        this.data = data;
        this.hora = hora;
        this.cor = cor;
        this.status = status;
        this.dataEntrega = dataEntrega;
        this.horaEntrega = horaEntrega;
        this.valor = valor;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
