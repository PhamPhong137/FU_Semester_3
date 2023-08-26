package Queue;


public class MyQueue {

    private Node head, tail;
    
    public MyQueue() {
	head = tail = null;
    }

    // Check empty list
    public boolean isEmpty() {
	return head == null;
    }
    
    public Object front() throws Exception {
        if (isEmpty()) throw new Exception();
        return head.value;
    }
    
    public void enQueue(Object x) { //Bản chất là addLast
        if (isEmpty()) head = tail = new Node(x);
        else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }
 
    public Object deQueue() throws Exception { // Bản chất là deleteFirst
        if (isEmpty()) throw new Exception();
        Object x = head.value;
        head = head.next;
        if (head == null) tail = null;
        return x;
    }
            
    public void display() throws Exception {
        if (isEmpty()) throw new Exception();
        
	Node cur = head;
        
	while (cur != null) {
            if (cur == tail) System.out.print(cur.value + "\n");
            else System.out.println(cur.value + " <- ");
	}
    }
}
