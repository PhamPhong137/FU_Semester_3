/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcps;

/**
 *
 * @author PC-Phong
 */
public class DCPS {

    public static void main(String[] args) {
        Validate v = new Validate();
        calculatorMatrix cl = new calculatorMatrix();       
        while (true) {
            cl.inputMenu();
            int choice = v.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                   
                    cl.addsubMatrix(true);
                    break;
                case 2:
                    cl.addsubMatrix(false);
                    break;
                case 3:
                    
                    cl.mulMatrix();
                    break;
                case 4:
                    System.exit(0);
            }
        }

    }

}
