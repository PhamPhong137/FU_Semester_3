/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg42loc.chuvidientich;

import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class Validate {

    public double inputDouble() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                double n = Double.parseDouble(sc.nextLine());
                if (n >= 0) {
                    return n;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Try again");
            }
        }
    }

    public boolean checkTriangle(double a, double b, double c) {

        if (a + b > c && b + c > a && a + c > b) {
            return true;
        }
        System.out.println("Invalid Triangle");
        return false;
    }

    public boolean checkRectangle(double a, double b) {

        if (a <= b) {
            return true;
        }
        System.out.println("Width must less than length ");
        return false;
    }

}
