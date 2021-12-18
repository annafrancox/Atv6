package usuario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Usuario {
    private int id, idade;
    private String nome, sexo, dataNascimento;

    public Usuario(int id, String nome, String sexo, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.setIdade();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade() {
        this.calculaIdade();
    }

    public void calculaIdade() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String data = dateFormat.format(cal.getTime());

        String dataParts[] = data.split("/");
        String usuarioDataNascimento[] = this.dataNascimento.split("/");

        if(Integer.parseInt(dataParts[1]) > Integer.parseInt(usuarioDataNascimento[1])) {
            this.idade = Integer.parseInt(dataParts[0]) - Integer.parseInt(usuarioDataNascimento[0]);
        }
        else if(Integer.parseInt(dataParts[1]) < Integer.parseInt(usuarioDataNascimento[1])) {
            this.idade = Integer.parseInt(dataParts[0]) - Integer.parseInt(usuarioDataNascimento[0]) - 1;
        }
        else {
            if(Integer.parseInt(dataParts[2]) >= Integer.parseInt(usuarioDataNascimento[2])) {
                this.idade = Integer.parseInt(dataParts[0]) - Integer.parseInt(usuarioDataNascimento[0]);
            }
            else {
                this.idade = Integer.parseInt(dataParts[0]) - Integer.parseInt(usuarioDataNascimento[0]) - 1;
            }
        }
    }

}
