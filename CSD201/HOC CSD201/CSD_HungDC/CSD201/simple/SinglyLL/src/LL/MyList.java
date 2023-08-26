package LL;

public class MyList {
    
    private Node head, tail;
    
    public MyList() {
	head = tail = null;
    }

    // Check empty list
    private boolean isEmpty() {
	return head == null;
    }

    // Print list
    public void display() {
        if (isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
	Node cur = head;
        
	while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
	}
	System.out.println();
    }
    
    // Add last node
    public void addLast(int value) {
	Node node = new Node(value);
	if (isEmpty()) {
            head = tail = node;
	}
	else {
            tail.next = node;
            tail = node;
	}
    }
    
    // Add first node
    public void addFirst(int value) {
	Node node = new Node(value);
	if (isEmpty()) {
            head = tail = node;
	}
	else {
            node.next = head;
            head = node;
	}
    }

    // Add node after a specific node
    public void addAfterIndex(int value, int index) {
	if (index < 0) {
            addFirst(value);
            return;
	}
	if (index >= size()) {
            addLast(value);
            return;
	}
	int count = 0;
	Node cur = head;
	while (cur != null && count != index) {
            count++;
            cur = cur.next;
	}
	if (cur == null) {}
        else {
            Node node = new Node(value);
            node.next = cur.next;
            cur.next = node;
	}
    }
    
    // Get size
    public int size() {
        Node cur = head; int k = 0;
        while (cur != null) {
            k++;
            cur = cur.next;
        }
        return k;
    }
    
    // Get node followed by index
    public Node get(int index) {
        Node cur = head;
        if (index >= size()) get(size()-1);
        for (int i = 2; i <= index; i++) {
            cur = cur.next;
        }
        return cur;
    }
    
    // Delete last node
    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        if (head.next == null) {
            head = null;
        }
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        tail = cur;
    }
    
    // Delete first node
    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        if (head.next == null) {
            head = null;
        }
        Node cur = head;
        head = cur.next;
    }
    
    // Delete specific node
    public void deleteIndex(int index) {
        if (index <= 1) {
            deleteFirst();
            return;
        }
        if (index >= size()) {
            deleteLast();
            return;
        }
        int pos = 1;
        Node cur = head;
        while (pos < index - 1) {
            cur = cur.next;
            ++pos;
        }
        cur.next = cur.next.next;
    }
    
    void sort(int start, int end) {
        if (start >= end || start >= size() || end >= size()) return;
        for (int i = start; i < end; i++) {
            for (int j = i+1; j <= end; j++) {
                if (get(i).value > get(j).value) {
                    int tmp = get(i).value;
                    get(i).value = get(j).value;
                    get(j).value = tmp;
                }
            }
        }
    }
}
