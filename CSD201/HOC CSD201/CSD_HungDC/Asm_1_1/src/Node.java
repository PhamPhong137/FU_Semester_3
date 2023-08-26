
public class Node {
    
    Car info; //data of Node
    Node next;
    //create a new Node 
    Node(Car info, Node next) {
        this.info = info;
        this.next = next;
    }
    
    Node(Car info) {
        this(info,null);
    }
}
