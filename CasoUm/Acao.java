package casoum;

import java.util.Stack;

public class Acao {
    private String tipo;
    private Paciente paciente;
    private Consulta consulta;

    public Acao(String tipo, Paciente paciente, Consulta consulta) {
        this.tipo = tipo;
        this.paciente = paciente;
        this.consulta = consulta;
    }

    public String getTipo() {
        return tipo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    private static Stack<Acao> historicoAcoes = new Stack<>();

    public static void adicionarAcao(Acao acao) {
        historicoAcoes.push(acao);
    }

    public static void desfazerUltimaAcao(ListaEncadeada<Paciente> pacientes, ListaEncadeada<Consulta> consultas) {
        if (!historicoAcoes.isEmpty()) {
            Acao ultimaAcao = historicoAcoes.pop();
            switch (ultimaAcao.getTipo()) {
                case "agendar":
                    consultas.remover(ultimaAcao.getConsulta());
                    System.out.println("Última consulta agendada foi desfeita.");
                    break;
                case "atualizar":
                    pacientes.remover(ultimaAcao.getPaciente());
                    System.out.println("Última atualização do paciente foi desfeita.");
                    break;
                default:
                    System.out.println("Ação desconhecida.");
                    break;
            }
        } else {
            System.out.println("Nenhuma ação para desfazer.");
        }
    }

    public static void visualizarHistorico() {
        if (historicoAcoes.isEmpty()) {
            System.out.println("Histórico de ações está vazio.");
        } else {
            System.out.println("Histórico de Ações:");
            for (Acao acao : historicoAcoes) {
                System.out.println("Ação: " + acao.getTipo() + ", Paciente: " + (acao.getPaciente() != null ? acao.getPaciente().getNome() : "N/A") + ", Consulta: " + (acao.getConsulta() != null ? acao.getConsulta().getData() : "N/A"));
            }
        }
    }
}
