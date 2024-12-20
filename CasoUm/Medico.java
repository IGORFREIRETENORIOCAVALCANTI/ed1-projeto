package casoum;

public class Medico {
    private String nome;
    private String especialidade;
    private boolean disponibilidade;

    public Medico(String nome, String especialidade, boolean disponibilidade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponibilidade = disponibilidade;
    }
    @Override
    public String toString() {
        return "Nome: " + nome + ", Especialidade: " + especialidade + ", Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}

