package Model;

public class Saidas {
    private int id;
    private int idProduto;
    private String dataSaida;
    private double quantidade;
    private String destinatario;

    public Saidas(int id, int idProduto, String dataSaida, double quantidade, String destinatario) {
        this.id = id;
        this.idProduto = idProduto;
        this.dataSaida = dataSaida;
        this.quantidade = quantidade;
        this.destinatario = destinatario;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public String getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }
    public double getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}