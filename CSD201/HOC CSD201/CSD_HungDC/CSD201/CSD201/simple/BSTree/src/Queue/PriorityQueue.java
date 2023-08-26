package Queue;


public class PriorityQueue {
    protected int[] a;
    int top, max; // For last index and max index of the array
    
    public PriorityQueue() {
        this(50);
    }
    
    public PriorityQueue(int max1) {
        max = max1;
        a = new int[max];
        top = -1;
    }
    
    protected boolean grow() {
        int max1 = max + max/2;
        int[] a1 = new int[max1];
        if (a1 == null) return false;
        for (int i = 0; i <= top; i++) {
            a1[i] = a[i];
        }
        a = a1;
        return true;
    }
    
    private boolean isEmpty() {
        return top == -1;
    }
    
    private boolean isFull() {
        return top == max - 1;
    }
    
    public void clear() {
        top = -1;
    }
    
    public void enQueue(int x) throws Exception {
        if (isFull() && !grow()) throw new Exception("Array is full!");
        if (top == -1) {
            a[0] = x;
            top = 0;
            return;
        }
        int i = top;
        while (i >= 0 && x < a[i]) {
            a[i+1] = a[i];
            i--;
        }
        a[i+1] = x;
        top++;
    }
    
    public int front() {
        assert(!isEmpty());
        return a[top];
    }
    
    public int deQueue() {
        assert(!isEmpty());
        int x = a[top];
        top--;
        return x;
    }
    
    public void display() throws Exception {
        if (top == -1) throw new Exception();
        for (int i = 0; i <= top; i++) {
            if (i == top) System.out.print(a[i] + "\n");
            else System.out.print(a[i] + " <- ");
        }
    }
}
