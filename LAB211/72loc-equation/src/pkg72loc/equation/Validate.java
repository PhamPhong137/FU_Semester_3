/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg72loc.equation;

import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Input again");
            }
        }
    }

    public float checkFloat(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                float n = Float.parseFloat(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
            }
        }
    }
}
