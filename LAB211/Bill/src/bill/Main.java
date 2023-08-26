/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;

/**
 *
 * @author PC-Phong
 */
public class Main {

    public static void main(String[] args) {
        Validate v = new Validate();
        Bill b = new Bill();

        System.out.print("Input number of bill:");
        int n = v.inputInt();
        int[] a = b.inputValueofarray(n);
        System.out.print("Input value of wallet: ");
        int wallet = v.inputInt();
        b.printBill(a, wallet);
    }

}
