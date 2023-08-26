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
public class Bill {

    public int[] inputValueofarray(int n) {
        Validate v = new Validate();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Input value of bill " + (i + 1) + ": ");
            a[i] = v.inputInt();
        }
        return a;
    }

    public int totalBill(int a[]) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public boolean payMoney(int total, int wallet) {
        if (total <= wallet) {
            return true;
        }
        return false;
    }

    public void printBill(int a[], int wallet) {
        int sum = totalBill(a);

        System.out.println("This is total of bill: " + sum);
        if (payMoney(sum, wallet)) {
            System.out.println("You can buy it");
        } else {
            System.out.println("You cann't buy it");
        }
    }
}
