/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;

import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public int inputInt() {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < 0) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println("Try again");
            }
        }
    }
}
