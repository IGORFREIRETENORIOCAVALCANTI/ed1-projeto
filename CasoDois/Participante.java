package casodois;

import java.util.ArrayList;
import java.util.List;

public class Participante {
    private String nome;
    private int numeroInscricao;
    private List<Evento> eventosInscritos;

    public Participante(String nome, int numeroInscricao) {
        this.nome = nome;
        this.numeroInscricao = numeroInscricao;
        this.eventosInscritos = new ArrayList<>();
    }

    public void inscreverNoEvento(Evento evento) {
        eventosInscritos.add(evento);
    }

    public List<Evento> getEventosInscritos() {
        return eventosInscritos;
    }

    @Override
    public String toString() {
        StringBuilder eventos = new StringBuilder();
        for (Evento evento : eventosInscritos) {
            eventos.append(evento.getNome()).append(", ");
        }
        return "Participante: " + nome + ", Número de Inscrição: " + numeroInscricao + ", Eventos Inscritos: " + eventos.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(int numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }


}


