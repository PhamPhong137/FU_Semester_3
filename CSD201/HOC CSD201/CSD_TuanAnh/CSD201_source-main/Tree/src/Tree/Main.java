/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        MyTree my = new MyTree();//dung du lieu dung khi xoa
        my.add(new Car("A", 8));
        my.add(new Car("B", 4));
        my.add(new Car("C", 12));
        my.add(new Car("D", 2));
        my.add(new Car("E", 6));
        my.add(new Car("F", 10));
        my.add(new Car("H", 14));
        my.add(new Car("I", 1));
        my.add(new Car("J", 3));
//        MyTree my = new MyTree();//nhap du lieu dung khi quay cay
//        my.add(new Car("A", 15));
//        my.add(new Car("B", 14));
//
//        my.add(new Car("C", 16));
//        my.add(new Car("D", 11));
//        my.add(new Car("E", 10));
//        my.add(new Car("E", 12));
//        
//        my.add(new Car("F", 13));
//        my.add(new Car("H", 17));
//        my.add(new Car("I", 6));
//        my.add(new Car("J", 5));
//        
//        my.add(new Car("H", 5));
//        my.add(new Car("I", 7));
//        my.add(new Car("K", 9));
//        my.add(new Car("L", 11));
//        my.add(new Car("M", 13));
//        my.add(new Car("O", 15));

        //f0 cac thuat toan duy tree
//        System.out.println("In order");
//        my.InOrder();
//        System.out.println("");
//        System.out.println("Pre Order");
//        my.preOrder();
//        System.out.println("");
//        System.out.println("Post Order");
//        my.postOrder();
        System.out.println("Breadth begining ");
        my.BreadthFirstOrder();

        //f1 xoa va quay node
//        Node q = my.rotateRight(my.root.right);//quay R cua node root.right
//        my.root.right = q; //quay R cua node root.right
//        my.deleteByCopyL(my.root.left);// deleteByCopyL node 4: dua tan cung ben phai len (3)
//        my.deleteByCopyL(my.root.left);// deleteByCopyL node 4, sau do deleteByCopyL node 3
        my.deleteMerging(my.root); // deleteByMerging diem root 8
//        my.deleteMerging(my.root.right);// deleteByMerging diem 12
//        my.deleteMerging(my.root.left);//xoa node 4_ cach 0

        //f1. xoa deleteByCopyL voi node bat ky:
//        Node p = my.findNode(4);//xoa diem p bat ky(tru node la)_cach 1
        //Node p = my.findNode(3);//khong xoa dc 3 vi 3 la node la, phai viet lai ham
//        my.deleteByCopyL(p);
//        my.deleteByCopyL(my.findNode(4));// xoa node 4_ cach 2
//        my.deleteByCopyL(my.findNode(9));// ko xoa dc node 9 vi la leaf node
//f2. xoa deleteByMerging(p) bat ky
        //Node p = my.findNode(8);//tim diem 8
        //my.deleteMerging(p);//xoa diem p bat ky
        // Node p = my.findNode(4);// tim diem 4 _ cach 2
        //my.deleteMerging(p);//xoa diem p bat ky_ cach 2
        //f3.quay trai_OK
//       Node p = my.findNode(10);//neu quay node 4
//       if(p==null){
//           System.out.println("Khong ton tai node p");
//       }
//       else{
//           Node father = my.getParent(p);
//           Node after = my.rotateLeft(p);//quay trai
//           if(father == null){
//               my.root = after;
//           }
//           else{
//               if(father.value.price>p.value.price){
//                   father.left = after;
//               }
//               else{
//                   father.right = after;
//               }
//           }
//       }
//f4. quay phai_OK
//       Node p = my.findNode(15);//neu quay node 4
//       if(p == null){
//           System.out.println("Khong ton tai node p");
//       }
//       else{
//           Node father = my.getParent(p);
//           Node after = my.rotateRight(p);//quay phai
//           if(father == null){
//               my.root = after;
//           }
//           else{
//               if(father.value.price<p.value.price){
//                   father.right = after;
//               }else{
//                   father.left=after;
//               }
//           }
//       }
        System.out.println("");
        System.out.println("Breadth after ");
        my.BreadthFirstOrder();
    }
}
