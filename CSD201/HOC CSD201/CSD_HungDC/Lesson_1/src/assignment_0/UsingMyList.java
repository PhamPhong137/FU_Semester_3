/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_0;

/**
 *
 * @author Admin
 */
public class UsingMyList {
    public static MyList my = new MyList();
    
    public static void Generate(){
        my.addLast(2);
        my.addLast(5);
        my.addLast(7);
        my.addLast(8);
        my.addLast(10);
        my.addFirst(23);
        my.addFirst(20);
        my.addFirst(13);
        my.addFirst(17);
        my.addFirst(9);
        my.display();
    }
    
    public static void main(String[] args) {
        //bai 1:
//        //cau 0: addLast, addFirst:
//        Generate();
//        //cau 1: add so 99 vao sau phan tu thu 5
//        Generate();
//        my.addIndex(5, 99);
//        my.display();
//        //cau 2: add so 99 vao sau SNT dau tien
//        Generate();
//        int index1= my.findIndex1();
//        my.addIndex(index1, 99);
//        my.display();
//        //cau3: add so 99 vao sau SNT thu 2
//        Generate();
//        int index2 = my.findIndex2();
//        my.addIndex(index2, 99);
//        my.display();
//        //cau4: add so 99 vao sau SNT cuoi cung
//        Generate();
//        int index3 = my.findIndex3();
//        my.addIndex(index3, 99);
//        my.display();
        
        //bai 2:
//        //cau 1: xoa phan tu thu 3
//        Generate();
//        my.deleteIndex(2);
//        my.display();
//        //cau 2: xoa 2 SNT dau tien
//        Generate();
//        int i=0;
//        Node cu = new Node();
//        cu = my.head;
//        int count=0;
//        while(i<my.size && cu!= null){
//            if(my.checkPrime(cu.value)){
//                my.deleteIndex(i);
//                i--;
//                count++;
//            }
//            cu = cu.next;
//            i++;
//            if(count==2){
//                break;
//            }
//        }
//        my.display();
//       //cau 3: xoa 2 SNT cuoi cung//       
//        Generate();
//        my.deleteIndex(my.findIndex3()-1);
//        my.deleteIndex(my.findIndex3()-1);
//        my.display();
//        //cau 4: xoa tat SNT
//        Generate();
//        int i=0;
//        Node cu = new Node();
//        cu = my.head;
//        while(i<my.size && cu != null){
//            if(my.checkPrime(cu.value)){
//                my.deleteIndex(i);
//                i--;
//            }
//            cu = cu.next;
//            i++;
//        }
//        my.display();  
//        //cau 5: xoa tat ca so chan
//        Generate();
//        int i=0;
//        Node cu = new Node();
//        cu = my.head;
//        while(i<my.size && cu != null){
//            if(cu.value %2 == 0){
//                my.deleteIndex(i);
//                i--;
//            }
//            cu = cu.next;
//            i++;
//        }
//        my.display();
        //cau 6: xoa tat ca so le
        Generate();
        int i=0;
        Node cu = new Node();
        cu = my.head;
        while(cu != null){
            if(cu.value % 2 != 0){
                my.deleteIndex(i);
                i--;
            }
            cu = cu.next;
            i++;
        }
        my.display();
    }
}
