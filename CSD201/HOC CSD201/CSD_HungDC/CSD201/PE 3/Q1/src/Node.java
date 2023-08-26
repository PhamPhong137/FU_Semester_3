// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Node {
  Bee info;
  Node next;
  Node() {
   }
  Node(Bee x, Node p) {
    info=x;next=p;
   }
  Node(Bee x) {
    this(x,null);
   }
 }

