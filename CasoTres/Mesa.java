package CasoTres;

public class Mesa {
    private int numero;
    private String cliente;
    private String status;

    public Mesa(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.status = cliente.isEmpty() ? "livre" : "ocupada";
    }

    @Override
    public String toString() {
        return "Mesa: " + numero + ", Cliente: " + (cliente.isEmpty() ? "Nenhum" : cliente) + ", Status: " + status;
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
        this.status = cliente.isEmpty() ? "livre" : "ocupada";
    }

    public String getStatus() {
        return status;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
