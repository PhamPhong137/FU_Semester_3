// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Node {
  Bison info;
  Node next;
  Node() {
   }
  Node(Bison x, Node p) {
    info=x;next=p;
   }
  Node(Bison x) {
    this(x,null);
   }
 }

