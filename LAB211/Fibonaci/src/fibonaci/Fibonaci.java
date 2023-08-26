/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonaci;

/**
 *
 * @author PC-Phong
 */
public class Fibonaci {

    public static int Fibonaci(int n, int lower, int higher) {
        System.out.print(higher + " ");
        if (n < 2) {
            return higher;
        }

        return Fibonaci(n - 1, higher, higher + lower);
    }

    public static void main(String[] args) {
        Fibonaci(45, 1, 0);
    }

//    public static int fibonaci(int n) {
//        if (n < 2) {
//            return n;
//        }
//        return fibonaci(n - 1) + fibonaci(n - 2);
//    }
//
//    public static void main(String[] args) {
//        int a[] = new int[45];
//        for (int i = 0; i < 45; i++) {
//            a[i]= fibonaci(i);
//            System.out.println(a[i]);
//        }
//        System.out.println(fibonaci(44));
//    }
}
