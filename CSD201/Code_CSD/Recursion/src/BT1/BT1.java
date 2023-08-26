/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BT1;

/**
 *
 * @author PC-Phong
 */
public class BT1 {

    public static double recu(int n) {
        if (n == 1) {
            return 1;
        }
        return recu(n - 1) * 0.5;

    }

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            System.out.print(recu(i)+" ");
        }

    }

}
