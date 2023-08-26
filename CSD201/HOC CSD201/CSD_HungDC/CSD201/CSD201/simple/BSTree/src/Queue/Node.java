package Queue;

public class Node {
    Object value;
    Node next;

    public Node() {
    }

    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }
        
    public Node(Object value) {
        this(value, null);
    }
}