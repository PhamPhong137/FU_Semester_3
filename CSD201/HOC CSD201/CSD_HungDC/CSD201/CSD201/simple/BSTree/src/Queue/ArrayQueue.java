package Queue;


public class ArrayQueue {
    protected Object[] a;
    protected int max; // số lượng phần tử tối đa của mảng
    protected int first, last; // vị trí phần tử đầu, đuôi của mảng
    
    public ArrayQueue() {
        this(10);
    }
    
    public ArrayQueue(int max1) {
        max = max1;
        a = new Object[max];
        first = last = -1;
    }
    
    private boolean isEmpty() {
        return first == -1;
    }
    
    private boolean isFull() {
        return first == 0 && last == max-1 || first == last + 1;
    }
    
    private boolean grow() {
        int max1 = max + max/2;
        Object[] a1 = new Object[max1];
        if (a1 == null) return false; // Không hiểu
        if (last >= first)
            for (int i = 0; i <= last; i++) {
                a1[i - first] = a[i];
            }
        else {
            for (int i = first; i < max; i++) {
                a1[i - first] = a[i];
            }
            int i = max - first;
            for (int j = 0; j <= last; j++) {
                a1[i + j] = a[j];
            }
        }
        a = a1;
        first = 0;
        last = max - 1;
        max = max1;
        return true;
    }
    
    public void enQueue(Object x) { // addLast
        if (isFull() && !grow()) return;
        if (last == max - 1 || last == -1) {
            a[0] = x;
            last = 0;
            if (first == -1) first = 0;
        }
        else a[++last] = x;
    }
    
    public Object front() throws Exception {
        if (isEmpty()) throw new Exception();
        return a[first];
    }
    
    public Object deQueue() throws Exception { // deleteFirst, tăng First
        if (isEmpty()) throw new Exception();
        Object x = a[first];
        if (first == last) first = last = -1;
        else if (first == max - 1) first = 0;
        else first++;
        return x;
    }
    
    public void display() {
        if (first == -1) {
            System.out.println("Empty array!");
            return;
        }
        for (int i = first; i <= last; i++) {
            if (i == last) System.out.print(a[i] + "\n");
            else System.out.print(a[i] + " <- ");
        }
    }
}
