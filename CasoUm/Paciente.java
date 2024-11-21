package casoum;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nome;
    private int idade;
    private String historicoMedico;
    private String dataUltimaConsulta;
    private List<Consulta> consultas;

    public Paciente(String nome, int idade, String historicoMedico, String dataUltimaConsulta) {
        this.nome = nome;
        this.idade = idade;
        this.historicoMedico = historicoMedico;
        this.dataUltimaConsulta = dataUltimaConsulta;
        this.consultas = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Histórico Médico: " + historicoMedico + ", Data da Última Consulta: " + dataUltimaConsulta;
    }

    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
        }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public String getDataUltimaConsulta() {
        return dataUltimaConsulta;
    }

    public void setDataUltimaConsulta(String dataUltimaConsulta) {
        this.dataUltimaConsulta = dataUltimaConsulta;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

}

