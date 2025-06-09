package Model;

import java.util.Date;

public class Relatorio {
    private int id;
    private String tipo;
    private Date data;
    private String detalhes;

    public Relatorio(int id, String tipo, Date data, String detalhes) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.detalhes = detalhes;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getDetalhes() {
        return detalhes;
    }
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}