package Model;

public class Entrada {
    private int id;
    private int idProduto;
    private String dataEntrada;
    private int quantidade;
    private double fornecedor;

    public Entrada(int id, int idProduto, String dataEntrada, int quantidade, double fornecedor) {
        this.id = id;
        this.idProduto = idProduto;
        this.dataEntrada = dataEntrada;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
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
    public String getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(double fornecedor) {
        this.fornecedor = fornecedor;
    }
}
