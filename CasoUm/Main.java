package casoum;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        ListaEncadeada<Paciente> pacientes = new ListaEncadeada<>();
        ListaEncadeada<Medico> medicos = new ListaEncadeada<>();
        ListaEncadeada<Consulta> consultas = new ListaEncadeada<>();

        // Inserções de exemplo
        Paciente pacienteExemplo = new Paciente("Cleito", 30, "Cagão", "10/10/2010");
        pacientes.inserir(pacienteExemplo);
        medicos.inserir(new Medico("Doutor Lambimia", "Urologista", true));

        // Criar consulta de exemplo
        String nomePacienteConsulta = "Cleito";
        String dataConsulta = "12/12/2024";
        Consulta consultaExemplo = new Consulta(nomePacienteConsulta, dataConsulta);
        consultas.inserir(consultaExemplo); // Insira a consulta de exemplo na lista de consultas
        pacientes.agendarConsulta(nomePacienteConsulta, dataConsulta);

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----------------------------");
            System.out.println("Menu:");
            System.out.println("1. Inserir novo paciente");
            System.out.println("2. Agendar consulta");
            System.out.println("3. Buscar paciente específico");
            System.out.println("4. Buscar médico específico");
            System.out.println("5. Atualizar consulta");
            System.out.println("6. Listar todos os pacientes");
            System.out.println("7. Listar todos os médicos");
            System.out.println("8. Listar todas as consultas");
            System.out.println("9. Visualizar histórico");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    System.out.println("----------------------------");
                    System.out.println("Nome do paciente:");
                    String nomePaciente = scanner.nextLine();
                    System.out.println("Idade do paciente:");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Histórico médico do paciente:");
                    String historicoMedico = scanner.nextLine();
                    System.out.println("Data da última consulta (dd/mm/yyyy):");
                    String dataUltimaConsulta = scanner.nextLine();
                    Paciente novoPaciente = new Paciente(nomePaciente, idade, historicoMedico, dataUltimaConsulta);
                    pacientes.inserir(novoPaciente);
                    Acao.adicionarAcao(new Acao("inserir", novoPaciente, null));
                    break;
                case 2:
                    System.out.println("----------------------------");
                    System.out.println("Nome do paciente para agendar consulta:");
                    nomePacienteConsulta = scanner.nextLine();
                    System.out.println("Data da consulta (dd/mm/yyyy):");
                    dataConsulta = scanner.nextLine();
                    Consulta consulta = new Consulta(nomePacienteConsulta, dataConsulta);
                    pacientes.agendarConsulta(nomePacienteConsulta, dataConsulta);
                    consultas.inserir(consulta); // Adicione a consulta à lista de consultas
                    Acao.adicionarAcao(new Acao("agendar", null, consulta));
                    break;
                case 3:
                    System.out.println("----------------------------");
                    System.out.println("Nome do paciente a ser buscado:");
                    String buscaPaciente = scanner.nextLine();
                    Paciente pacienteEncontrado = (Paciente) pacientes.buscaPaciente(buscaPaciente);
                    if (pacienteEncontrado == null) {
                        System.out.println("Paciente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("----------------------------");
                    System.out.println("Nome do médico a ser buscado:");
                    String buscaMedico = scanner.nextLine();
                    Medico medicoEncontrado = (Medico) medicos.buscaMedico(buscaMedico);
                    if (medicoEncontrado == null) {
                        System.out.println("Médico não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("----------------------------");
                    System.out.println("Nome do paciente para atualizar consulta:");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.println("Data da consulta a ser atualizada (dd/mm/yyyy):");
                    String dataConsultaAtualizar = scanner.nextLine();
                    Consulta consultaAtualizar = pacientes.atualizarConsulta(nomeAtualizar, dataConsultaAtualizar);
                    Acao.adicionarAcao(new Acao("atualizar", null, consultaAtualizar));
                    break;
                case 6:
                    System.out.println("----------------------------");
                    System.out.println("Lista de todos os pacientes:");
                    pacientes.listarTodosPacientes();
                    break;
                case 7:
                    System.out.println("----------------------------");
                    System.out.println("Lista de todos os médicos:");
                    medicos.listarTodosMedicos();
                    break;
                case 8:
                    System.out.println("----------------------------");
                    System.out.println("Lista de todas as consultas:");
                    pacientes.listarConsultas();
                    break;
                case 9:
                    System.out.println("----------------------------");
                    Acao.visualizarHistorico();
                    System.out.println("Deseja desfazer a última ação? (s/n)");
                    String desfazer = scanner.nextLine();
                    if (desfazer.equalsIgnoreCase("s")) {
                        Acao.desfazerUltimaAcao(pacientes, consultas);
                    }
                    break;
                case 0:
                    System.out.println("----------------------------");
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("----------------------------");
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
