
public class MyList {

    Node head, tail;
    int size;

    public MyList() {
        head = tail = null;
    }

    //return true if Mylist is empty otherwise return false
    public boolean isEmpty() {
        return head == null;
    }

    //append a new node to the end of list
    public void addLast(String name, double price) {
        Car x = new Car(name, price);
        Node p = new Node(x);
        if (name.startsWith("B") || price > 100) {
            return;
        }
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    //output list
    public void display() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info.toString() + "  ");
            p = p.next;
        }
        System.out.println("");
    }

    //return number of nodes in the list
    public int size() {
        Node p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }

    // add after a node
    public void addIndex(String name, double price, double value) {
        Node p = head;
        while (p != null) {
            if (p.info.getPrice() < value) {
                break;
            }
            p = p.next;
        }
        Car x = new Car(name, price);
        Node newNode = new Node(x);
        // add new node
        newNode.next = p.next;
        p.next = newNode;
    }
    
    // check prime
    public boolean checkPrime(int n){ 
        if(n<2) return false;
        for (int i=2; i<= Math.sqrt(n); i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    // find the index of the last Prime
    public int findLastPrime(){
        int index = 0;
        int indexFound=0;
        Node p = head;
        while(p!=null){
            if(checkPrime((int)p.info.getPrice())){
                indexFound = index;
            }
            p=p.next;
            index++;
        }
        return indexFound+1;
    }
    
    
    // delete the first prime
    public void deleteFisrtPrime(){
        size = size();
        Node p = head;
        while (p!= null){
            if (checkPrime((int)p.next.info.getPrice())){
                p.next = p.next.next;
                size--;
                break;
            }
            p = p.next;
        }
    }

}
