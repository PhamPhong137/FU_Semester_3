// ======= DO NOT EDIT THIS FILE ============
class Node {
  Castor info;
  Node next;
  Node() {
   }
  Node(Castor x, Node p) {
    info=x;next=p;
   }
  Node(Castor x) {
    this(x,null);
   }
 }

