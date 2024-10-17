package CasoDois;

public class ListaDuplamenteEncadeada<T> {
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

    public void remover(T data) {
        Node<T> temp = head;
        while (temp != null && !temp.data.equals(data)) {
            temp = temp.next;
        }
        if (temp != null) {
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            } else {
                head = temp.next;
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        }
    }

    public void buscar(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                System.out.println(temp.data.toString());
                return;
            }
            temp = temp.next;
        }
        System.out.println("Elemento não encontrado.");
    }

    public void listarTodos() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }

    public void decrementarNumeroDeParticipantes(Participante participante) {
        for (Evento evento : participante.getEventosInscritos()) {
            evento.getParticipantes().remove(participante);
        }
    }
    

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
