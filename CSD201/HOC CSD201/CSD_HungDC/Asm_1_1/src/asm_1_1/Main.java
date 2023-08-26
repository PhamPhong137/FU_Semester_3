/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_1_1;

/**
 *
 * @author Admin
 */
public class Main {
    public static List li = new List();

    public static void addLastElement() {
        li.addLast("A", 20);
        li.addLast("C", 18);
        li.addLast("D", 15);
        li.addLast("E", 25);
        li.addLast("A", 3);
        li.addLast("A", 5);
        li.addLast("A", 9);
    }

    public static void addFisrtElement() {
        li.addFirst("T", 9);
        li.addFirst("T", 7);
        li.addFirst("N", 10);
        li.addFirst("T", 2);
        li.addFirst("T", 6);
    }

    public static void main(String[] agrs) {
//      //cau 1:addLast nếu Name khác 'B' hoặc price<100
//        addFisrtElement();
//        addLastElement();
//        li.display();
      //câu 2: thêm vào sau phần tử đầu tiên có price<value
//        addFisrtElement();
//        addLastElement();
//        li.display();
//        li.addSmallerIndex("F",30,16);
//        li.display();
//      // câu 3: xóa phần tử đầu tiên và cuối cùng là snt
//        addFisrtElement();
//        addLastElement();
//        li.display();
//        li.deletePrime();
//        li.display();
      //câu 4: đưa min về đầu, đưa max về cuối
//        addFisrtElement();
//        addLastElement();
//        li.display();
//        li.moveMax();
//        li.display();
//        li.moveMin();
//        li.display();
      //câu 5.1:sắp xếp 3 phần tử đầu tiên là SNT
//        addFisrtElement();
//        addLastElement();
//        li.display();
//        li.sortThreeFirstPrimePrice();
//        li.display();
      //câu 5.2:sắp xếp 3 phần tử cuối cùng là SNT
        addFisrtElement();
        addLastElement();
        li.display();
        li.sortThreeLastPrimePrice();
        li.display();
    }
}
