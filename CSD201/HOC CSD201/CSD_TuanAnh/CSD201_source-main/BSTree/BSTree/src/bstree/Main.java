/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTree;

public class Main {

    //(A,5) (C,2) (E,4) (G.3) (D,6) (F,7)
    // (C,2) (G.3) (E,4) (A,5) (D,6) (F,7)
    static void f1() {
        MyTree my = new MyTree();
        my.insert("A", 5);
        my.insert("C", 2);
        my.insert("E", 4);
        my.insert("G", 3);
        my.insert("D", 6);
        my.insert("F", 7);
        //System.out.println("Breadth begining ");
        my.preOrder();
        Node p = my.findNode(4);//neu quay node 4
        if (p == null) {
            System.out.println("Khong ton tai node p");
        } else {
            Node father = my.getParent(p);
            Node after = my.rotateRight(p);//quay phai
            if (father == null) {
                my.root = after;
            } else {
                if (father.value.price < p.value.price) {
                    father.right = after;
                } else {
                    father.left = after;
                }
            }
        }
        //System.out.println("In order");
        System.out.println("");
        my.InOrder();
        System.out.println("");
    }

    static void f2() {

        //(C,6) (D,2) (F,4) (H.3) (I,5) (E,8) (G,7)
        MyTree my = new MyTree();
        my.add("C", 6);
        my.add("D", 2);
        my.add("F", 4);
        my.add("H", 3);
        my.add("I", 5);
        my.add("E", 8);
        my.add("G", 7);
        my.preOrder();
        System.out.println("");
        my.preOrder2();
        System.out.println("");
    }

    static void f3() {
        //(C,8) (D,6) (E,9) (F.2) (G.7) (H,1) (I,3) (J,5) (K,4)
        MyTree my = new MyTree();
        my.add("C", 8);
        my.add("D", 6);
        my.add("E", 9);
        my.add("F", 2);
        my.add("G", 7);
        my.add("H", 1);
        my.add("I", 3);
        my.add("J", 5);
        my.add("K", 4);
        my.BreadthFirstOrder();
        System.out.println("");
        my.BreadthFirstOrder3();
        my.BreadthFirstOrder();
        System.out.println("");

    }

    static void f4() {
//        (C,8) (D,6) (E,9) (F.2) (G.7) (H,1) (I,3) (J,5) (K,4)
        MyTree my = new MyTree();
        my.add("C", 8);
        my.add("D", 6);
        my.add("E", 9);
        my.add("F", 2);
        my.add("G", 7);
        my.add("H", 1);
        my.add("I", 3);
        my.add("J", 5);
        my.add("K", 4);
        my.BreadthFirstOrder();
        System.out.println("");
        my.BreadthFirstOrder4();
        my.BreadthFirstOrder();
        System.out.println("");
    }

    public static void main(String[] args) {
//        Void insert (string xOwner, int xPrice), check nếu xOwner.charA(0)=”B” hay xPrice>100 thì do nothing, ngược lại thì insert new car với owner=xOwner, price=xPrice vảo tree
//        Void f1(): Insert số liệu về Car, sau đó dùng các hàm đã học để hiển thị đầu ra:
//        f1();
//        Void f2(): Thực hiện PreOrder từ root nhưng display f2 các nodes có giá trong khoảng [3.5] ( thực hiện bằng cách copy hàm preOrder() thành hàm preorder2() và sửa nó. 
//        f2();
//        Void f3(): Thực hiện Breadth-First từ root và delete by copying node đầu tiên có 2 con và giá <7. Out put đầu ra có dạng
//        f3();
//        Void f4(): Thực hiện Breadth-First từ  root và tìm node p có con trái và giá nhỏ hơn 7. Quay p sang phải với con trái của nó. 
        f4();
    }

}
