package proyecto.edd1;

public class LinkedStack implements Stack {

    private Node head;
    private int size;

    public LinkedStack() {
        size = 0;
        head = null;

    }

    public boolean push(Object data) {
        if (head == null) {
            head.setData(data);
            return true;
        } else {
            Node temp = new Node();
            temp.setData(data);
            temp.setSiguiente(head);
            head.setAnterior(temp);
            head = temp;
        }
        size++;
        return true;
    }

    public Object pop() {
        if (head != null) {
            Node temp = head;
            head = temp.getSiguiente();
            head.setAnterior(null);
            temp.setSiguiente(null);
            size--;
            return temp.getData();
        } else {
            return null;
        }
    }

    public Object top() {
        if (head != null) {
            return head.getData();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        if (head != null) {
            head = null;
            size = 0;
        }
    }

    public void print() {
        Node temp = head;
        while (temp.getSiguiente() != null) {
            System.out.println(temp.getData()+", ");
            temp = temp.getSiguiente();
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Stack{" + '}';
    }
}
