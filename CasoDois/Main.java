package CasoDois;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<Evento> eventos = new ListaDuplamenteEncadeada<>();
        ListaDuplamenteEncadeada<Participante> participantes = new ListaDuplamenteEncadeada<>();

        // Inserções de exemplo
        Evento evento1 = new Evento("unicapela", "10/10/2024", "Recife", 100);
        Evento evento2 = new Evento("unicapitões", "20/20/2024", "Hellcife", 200);
        eventos.inserir(evento1);
        eventos.inserir(evento2);

        Participante participante1 = new Participante("cleito", 1);
        Participante participante2 = new Participante("rasta", 2);
        participantes.inserir(participante1);
        participantes.inserir(participante2);

        evento1.adicionarParticipante(participante1);
        evento2.adicionarParticipante(participante2);

        participante1.inscreverNoEvento(evento1);
        participante2.inscreverNoEvento(evento2);
        
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----------------------------");
            System.out.println("Menu:");
            System.out.println("1. Registrar novo evento");
            System.out.println("2. Registrar novo participante");
            System.out.println("3. Cancelar inscrição");
            System.out.println("4. Buscar evento específico");
            System.out.println("5. Buscar participante específico");
            System.out.println("6. Atualizar dados de um evento");
            System.out.println("7. Listar todos os eventos");
            System.out.println("8. Listar todos os participantes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    System.out.println("----------------------------");
                    System.out.println("Nome do evento:");
                    String nomeEvento = scanner.nextLine();
                    System.out.println("----------------------------");
                    System.out.println("Data do evento (dd/mm/yyyy):");
                    String dataEvento = scanner.nextLine();
                    System.out.println("----------------------------");
                    System.out.println("Local do evento:");
                    String localEvento = scanner.nextLine();
                    System.out.println("----------------------------");
                    System.out.println("Capacidade do evento:");
                    int capacidadeEvento = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("----------------------------");
                    Evento novoEvento = new Evento(nomeEvento, dataEvento, localEvento, capacidadeEvento);
                    eventos.inserir(novoEvento);
                    System.out.println("Evento registrado com sucesso.");
                    break;
                    case 2:
                        System.out.println("----------------------------");
                        System.out.println("Nome do participante:");
                        String nomeParticipante = scanner.nextLine();
                        System.out.println("----------------------------");
                        System.out.println("Número de inscrição:");
                        int numeroInscricao = scanner.nextInt();
                        System.out.println("----------------------------");
                        scanner.nextLine();
                        Participante novoParticipante = new Participante(nomeParticipante, numeroInscricao);
                        participantes.inserir(novoParticipante);
                        System.out.println("Nome do evento no qual está inscrito:");
                        String nomeEventoInscricao = scanner.nextLine();
                        System.out.println("----------------------------");
                        Evento eventoInscricao = buscarEventoPorNome(eventos, nomeEventoInscricao);
                        if (eventoInscricao != null) {
                            eventoInscricao.adicionarParticipante(novoParticipante);
                            novoParticipante.inscreverNoEvento(eventoInscricao);
                            System.out.println("Participante registrado com sucesso.");
                        } else {
                            System.out.println("Evento não encontrado.");
                        }
                        break;
                case 3:
                    System.out.println("----------------------------");
                    System.out.println("Número de inscrição do participante a ser cancelada:");
                    int numeroInscricaoCancelar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("----------------------------");
                    Participante participanteRemover = buscarParticipantePorNumero(participantes, numeroInscricaoCancelar);
                    if (participanteRemover != null) {
                        participantes.decrementarNumeroDeParticipantes(participanteRemover);
                        participantes.remover(participanteRemover);
                        System.out.println("Inscrição cancelada com sucesso.");
                    } else {
                        System.out.println("Participante não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("----------------------------");
                    System.out.println("Nome do evento a ser buscado:");
                    String nomeEventoBuscar = scanner.nextLine();
                    System.out.println("----------------------------");
                    buscarEventoPorNome(eventos, nomeEventoBuscar);
                    break;
                case 5:
                    System.out.println("----------------------------");
                    System.out.println("Nome do participante a ser buscado:");
                    String nomeParticipanteBuscar = scanner.nextLine();
                    System.out.println("----------------------------");
                    buscarParticipantePorNome(participantes, nomeParticipanteBuscar);
                    break;
                case 6:
                    System.out.println("----------------------------");
                    System.out.println("Nome do evento a ser atualizado:");
                    String nomeEventoAtualizar = scanner.nextLine();
                    System.out.println("----------------------------");
                    Evento eventoAtualizar = buscarEventoPorNome(eventos, nomeEventoAtualizar);
                    if (eventoAtualizar != null) {
                        System.out.println("Novo nome do evento:");
                        eventoAtualizar.setNome(scanner.nextLine());
                        System.out.println("----------------------------");
                        System.out.println("Nova data do evento (dd/mm/yyyy):");
                        eventoAtualizar.setData(scanner.nextLine());
                        System.out.println("----------------------------");
                        System.out.println("Novo local do evento:");
                        eventoAtualizar.setLocal(scanner.nextLine());
                        System.out.println("----------------------------");
                        System.out.println("Nova capacidade do evento:");
                        eventoAtualizar.setCapacidade(scanner.nextInt());
                        System.out.println("----------------------------");
                        scanner.nextLine();
                        System.out.println("Dados do evento atualizados com sucesso.");
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;
                case 7:
                    System.out.println("----------------------------");
                    System.out.println("Lista de todos os eventos:");
                    eventos.listarTodos();
                    break;
                case 8:
                    System.out.println("----------------------------");
                    System.out.println("Lista de todos os participantes:");
                    participantes.listarTodos();
                    break;
                case 0:
                    System.out.println("----------------------------");
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static Evento buscarEventoPorNome(ListaDuplamenteEncadeada<Evento> eventos, String nome) {
        Node<Evento> temp = eventos.getHead();
        while (temp != null) {
            if (temp.data.getNome().equalsIgnoreCase(nome)) {
                System.out.println(temp.data.toString());
                return temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Evento não encontrado.");
        return null;
    }

    private static Participante buscarParticipantePorNome(ListaDuplamenteEncadeada<Participante> participantes, String nome) {
        Node<Participante> temp = participantes.getHead();
        while (temp != null) {
            if (temp.data.getNome().equalsIgnoreCase(nome)) {
                System.out.println(temp.data.toString());
                return temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Participante não encontrado.");
        return null;
    }

    private static Participante buscarParticipantePorNumero(ListaDuplamenteEncadeada<Participante> participantes, int numeroInscricao) {
        Node<Participante> temp = participantes.getHead();
        while (temp != null) {
            if (temp.data.getNumeroInscricao() == numeroInscricao) {
                System.out.println(temp.data.toString());
                return temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Participante não encontrado.");
        return null;
    }
}

