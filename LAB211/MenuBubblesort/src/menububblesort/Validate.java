/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menububblesort;

import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public int checkInputChoice() {
        while (true) {
            
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= 1 && n <= 4) {
                    return n;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Try again");
            }
        }
    }

    public int checkInputnumberofArray() {
        while (true) {
            System.out.print("Input number of Array:");
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    return n;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please input number and number is greater than zero");
            }
        }
    }

    public int checkInputitemsofArray() {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Try again");
            }
        }
    }
}
