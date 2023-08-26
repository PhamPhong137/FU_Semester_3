/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication41;

/**
 *
 * @author Admin MSI
 */
public class JavaApplication41 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a = "DE102";
        String[] b = a.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        System.out.println(b[1]);
    }

}
