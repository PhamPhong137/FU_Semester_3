/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.pkg70loc;

import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public String inputYN() {

        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N):");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("Y")) {
                return choice;
            } else {
                System.out.println("Please input Y or N");
            }
        }
    }

    public double checkMark(String msg, int min, int max, String sub) {
        double mark;
        while (true) {
            System.out.print(msg);
            try {
                mark = Double.parseDouble(sc.nextLine().trim());
                if (mark < min) {
                    System.err.println(sub + "is greater than equal zero");
                } else if (mark > max) {
                    System.err.println(sub + "is less than equal ten");
                } else {
                    return mark;
                }
            } catch (Exception e) {
                System.err.println(sub + " is digit");
            }
        }
    }
    
}
