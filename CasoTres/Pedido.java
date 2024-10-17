package CasoTres;

public class Pedido {
    private String descricao;
    private int quantidade;
    private double total;
    private int mesa;

    public Pedido(String descricao, int quantidade, double total, int mesa) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.total = total;
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "Pedido: " + descricao + ", Quantidade: " + quantidade + ", Total: R$" + total + ", Mesa: " + mesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
}


