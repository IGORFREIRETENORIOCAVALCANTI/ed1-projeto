package casotres;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListaCircular<T> {
    private Node<T> head;
    private Node<T> tail;

    public void inserir(T data) {
        Node<T> novoNode = new Node<>(data);
        if (head == null) {
            head = novoNode;
            tail = novoNode;
            tail.next = head; // Faz a lista circular
        } else {
            tail.next = novoNode;
            tail = novoNode;
            tail.next = head; // Mantém a lista circular
        }
    }

    public void remover(T data) {
        if (head == null) return;

        Node<T> temp = head;
        Node<T> prev = tail;

        // Se o nó a ser removido é o head
        if (temp.data.equals(data)) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }

        do {
            if (temp.data.equals(data)) {
                prev.next = temp.next;
                if (temp == tail) {
                    tail = prev;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void buscar(T data) {
        if (head == null) {
            System.out.println("Elemento não encontrado.");
            return;
        }
        Node<T> temp = head;
        do {
            if (temp.data.equals(data)) {
                System.out.println(temp.data.toString());
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Elemento não encontrado.");
    }

    public T buscarPorDescricao(String descricao) {
        if (head == null) {
            return null;
        }
        Node<T> temp = head;
        do {
            if (temp.data.toString().contains(descricao)) {
                return temp.data;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public void atualizarPedido(String descricaoAntiga, String novaDescricao, int novaQuantidade, double novoTotal) {
        Pedido pedido = (Pedido) buscarPorDescricao(descricaoAntiga);
        if (pedido != null) {
            pedido.setDescricao(novaDescricao);
            pedido.setQuantidade(novaQuantidade);
            pedido.setTotal(novoTotal);
            System.out.println("Pedido atualizado com sucesso.");
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void listarTodosMesas() {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }
        List<Mesa> listaMesas = new ArrayList<>();
        Node<T> temp = head;
        do {
            if (temp.data instanceof Mesa mesa) {
                listaMesas.add(mesa);
            }
            temp = temp.next;
        } while (temp != head);

        listaMesas.sort(Comparator.comparingInt(Mesa::getNumero));

        for (Mesa mesa : listaMesas) {
            System.out.println(mesa.toString());
        }
    }

        public void listarTodosPedidos() {
            if (head == null) {
                System.out.println("Lista vazia.");
                return;
            }
            List<Pedido> listaPedidos = new ArrayList<>();
            Node<T> temp = head;
            do {
                if (temp.data instanceof Pedido pedido) {
                    listaPedidos.add(pedido);
                }
                temp = temp.next;
            } while (temp != head);
        
            for (Pedido pedido : listaPedidos) {
                System.out.println(pedido.toString());
            }
        }
        
        public void fecharConta(int numeroMesa) {
            Mesa mesa = (Mesa) buscarPorDescricao("Mesa: " + numeroMesa);
            if (mesa != null) {
                System.out.println("Nota Fiscal:");
                double totalConta = 0.0;
                Node<T> temp = head;
                do {
                    if (temp.data instanceof Pedido pedido) {
                        if (pedido.getMesa() == numeroMesa) {
                            System.out.println(pedido.toString());
                            totalConta += pedido.getTotal();
                        }
                    }
                    temp = temp.next;
                } while (temp != head);
                System.out.println("Total: R$" + totalConta);
                mesa.setStatus("livre");
                mesa.setCliente("");
                removerPedidosDaMesa(numeroMesa);
                System.out.println("Conta fechada e mesa " + numeroMesa + " está agora livre.");
            } else {
                System.out.println("Mesa não encontrada.");
            }
        }

        public void removerPedidosDaMesa(int numeroMesa) {
            Node<T> temp = head;
            do {
                if (temp.data instanceof Pedido pedido) {
                    if (pedido.getMesa() == numeroMesa) {
                        remover((T) pedido);
                        temp = head;
                    } else {
                        temp = temp.next;
                    }
                } else {
                    temp = temp.next;
                }
            } while (temp != head);
        }
        
           
        
    }