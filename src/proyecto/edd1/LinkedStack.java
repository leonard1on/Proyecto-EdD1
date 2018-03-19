package proyecto.edd1;

public class LinkedStack implements Stack {
    
    private Node head;
    private int size;
    
    public LinkedStack() {
        size = 0;
        head = null;
        
    }
    
    @Override
    public boolean push(Object data) {
        if (head == null) {
            head = new Node();
            head.setData(data);
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
    
    @Override
    public Object pop() {
        if (head != null) {
            Node temp = head;
            head = temp.getSiguiente();
            if (head!=null) {
                head.setAnterior(null);                
            }
            temp.setSiguiente(null);
            size--;
            return temp.getData();
        } else {
            return null;
        }
    }
    
    @Override
    public Object top() {
        if (head != null) {
            return head.getData();
        } else {
            return null;
        }
    }
    
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public void clear() {
        if (head != null) {
            head = null;
            size = 0;
        }
    }
    
    @Override
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData() + ", ");
            temp = temp.getSiguiente();
        }
        System.out.println("");
    }
    
    @Override
    public String toString() {
        return "Stack{" + '}';
    }
}
