package FizzBuzz;

public class SLL {
    public Node head;

    public SLL() {
        this.head = null;
    }

    public void add(int value) {
        // Crea un nuevo nodo con el valor proporcionado
        Node newNode = new Node(value);

        // Si la lista está vacía, el nuevo nodo será la cabeza de la lista
        if (head == null) {
            head = newNode;
        } else {
            // Si la lista no está vacía, coloca el nuevo nodo al final de la lista
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void removeFront() {
        // Verifica si la lista está vacía
        if (head == null) {
            throw new RuntimeException("La lista está vacía, no se puede eliminar ningún nodo.");
        }

        // Elimina el primer nodo moviendo la cabeza al siguiente nodo
        head = head.next;
    }

    // Clase interna para representar los nodos de la lista enlazada
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}

