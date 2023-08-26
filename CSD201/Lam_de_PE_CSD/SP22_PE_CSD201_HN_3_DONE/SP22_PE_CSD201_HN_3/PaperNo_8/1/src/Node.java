// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Node {
  Boo info;
  Node next;
  Node() {
   }
  Node(Boo x, Node p) {
    info=x;next=p;
   }
  Node(Boo x) {
    this(x,null);
   }
 }

