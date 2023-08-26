// =========================================================
// Do NOT modify this file 
// =========================================================

class Node{
    private House info;
    Node next;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (House x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    
    //Copy constructor
    Node (House x) {
        this(x,null);
    }
    
    public House getInfo() {
        return this.info;
    }
    
    public void setInfo(House inCala) {
        this.info = inCala;
    }
 }

