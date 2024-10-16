package CasoUm;

public class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;  // Referência ao nó anterior

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
