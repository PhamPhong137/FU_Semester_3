/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg72loc.equation;

/**
 *
 * @author PC-Phong
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========= Equation Program =========");
        Validate v = new Validate();
        Calculate cl = new Calculate();
        while (true) {
            cl.inputMenu();
            int choice = v.checkIntLimit(1, 3);
            switch (choice) {
                case 1:
                    cl.calculateSuperlativeEquation();
                    break;
                case 2:
                    cl.calculateQuadraticEquation();
                    break;
                case 3:
                    System.exit(0);

            }
        }

    }

}
