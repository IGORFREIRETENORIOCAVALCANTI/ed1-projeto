package casoum;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListaEncadeada<T> {
    private Node<T> head;
    
    public void inserir(T data) {
        Node<T> novoNode = new Node<>(data);
        if (head == null) {
            head = novoNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = novoNode;
            novoNode.prev = temp;
        }
    }
// pilha
    public boolean remover(T data) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(data)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public T buscaPaciente(String nome) {
        Node<T> atual = head;
        while (atual != null) {
            if (atual.data instanceof Paciente paciente) {
                if (paciente.getNome().equalsIgnoreCase(nome)) {
                    System.out.println("Nome: " + paciente.getNome());
                    System.out.println("Idade: " + paciente.getIdade());
                    System.out.println("Histórico Médico: " + paciente.getHistoricoMedico());
                    System.out.println("Data da Última Consulta: " + paciente.getDataUltimaConsulta());
                    return atual.data;
                }
            }
            atual = atual.next;
        }
        return null;
    }

    public T buscaMedico(String nome) {
        Node<T> atual = head;
        while (atual != null) {
            if (atual.data instanceof Medico medico) {
                if (medico.getNome().equalsIgnoreCase(nome)) {
                    System.out.println("Nome: " + medico.getNome());
                    System.out.println("Especialidade: " + medico.getEspecialidade());
                    System.out.println("Disponibilidade: " + (medico.isDisponibilidade() ? "Disponível" : "Indisponível"));
                    return atual.data;
                }
            }
            atual = atual.next;
        }
        return null;
    }

    public boolean nomeAtualizar(String nome, String novaDataConsulta) {
        Node<T> atual = head;
        while (atual != null) {
            if (atual.data instanceof Paciente paciente) {
                if (paciente.getNome().equalsIgnoreCase(nome)) {
                    paciente.setDataUltimaConsulta(novaDataConsulta);
                    return true;
                }
            }
            atual = atual.next;
        }
        return false;
    }

    public void listarTodosPacientes() {
        Node<T> atual = head;
        while (atual != null) {
            if (atual.data instanceof Paciente paciente) {
                System.out.println(paciente.getNome());
            }
            atual = atual.next;
        }
    }

    public void listarTodosMedicos() {
        Node<T> atual = head;
        while (atual != null) {
            if (atual.data instanceof Medico medico) {
                System.out.println(medico.getNome());
            }
            atual = atual.next;
        }
    }
    
    public void listarConsultas() {
        List<Consulta> todasConsultas = new ArrayList<>();
        Node<T> atual = head;
        while (atual != null) {
            if (atual.data instanceof Paciente) {
                Paciente paciente = (Paciente) atual.data;
                todasConsultas.addAll(paciente.getConsultas());
            }
            atual = atual.next;
        }
        Collections.sort(todasConsultas);
        for (Consulta consulta : todasConsultas) {
            if (!"Concluída".equals(consulta.getStatus())) {
                System.out.println(consulta.toString());
            }
        }
    }

    public void agendarConsulta(String nomePaciente, String dataConsulta) throws ParseException {
        Node<T> atual = head;
        Scanner scanner = new Scanner(System.in);
        while (atual != null) {
            if (atual.data instanceof Paciente paciente) {
                if (paciente.getNome().equalsIgnoreCase(nomePaciente)) {
                    while (!dataConsulta.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        System.out.println("Data no formato inválido. Use dd/mm/yyyy:");
                        dataConsulta = scanner.nextLine();
                    }
                    Consulta consulta = new Consulta(dataConsulta);
                    paciente.adicionarConsulta(consulta);
                    System.out.println("Consulta agendada para " + nomePaciente + " na data " + dataConsulta);
                    return;
                }
            }
            atual = atual.next;
        }
        System.out.println("Paciente não encontrado.");
    }


    public Consulta atualizarConsulta(String nomePaciente, String dataConsulta) {
        Node<T> atual = head;
        while (atual != null) {
            if (atual.data instanceof Paciente paciente) {
                if (paciente.getNome().equalsIgnoreCase(nomePaciente)) {
                    for (Consulta consulta : paciente.getConsultas()) {
                        if (consulta.getDataConsulta().equals(dataConsulta)) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("Consulta encontrada. Qual é o novo status? (Digite 1 para Concluída, 2 para Reagendada, 3 para Cancelada):");
                            String novoStatus = scanner.nextLine();
                            if (novoStatus.equalsIgnoreCase("1")) {
                                consulta.setStatus("Concluída");
                                paciente.setDataUltimaConsulta(consulta.getDataConsulta());
                            } else if (novoStatus.equalsIgnoreCase("3")) {
                                paciente.getConsultas().remove(consulta);
                            } else if (novoStatus.equalsIgnoreCase("2")) {
                                System.out.println("Informe a nova data da consulta (dd/mm/yyyy):");
                                String novaData = scanner.nextLine();
                                while (!novaData.matches("\\d{2}/\\d{2}/\\d{4}")) {
                                    System.out.println("Data no formato inválido. Use dd/mm/yyyy:");
                                    novaData = scanner.nextLine();
                                }
                                consulta.setDataConsulta(novaData);
                                consulta.setStatus("Agendada");
                            }
                            System.out.println("Consulta atualizada.");
                            return;
                        }
                    }
                    System.out.println("Consulta não encontrada.");
                    return;
                }
            }
            atual = atual.next;
        }
        System.out.println("Paciente não encontrado.");    
    }
    }



