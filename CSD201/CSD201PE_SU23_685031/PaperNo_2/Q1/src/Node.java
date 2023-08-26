// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Node {
  Boat info;
  Node next;
  Node() {
   }
  Node(Boat x, Node p) {
    info=x;next=p;
   }
  Node(Boat x) {
    this(x,null);
   }
 }

