/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menububblesort;

/**
 *
 * @author PC-Phong
 */
public class MenuBubblesort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SortArray s = new SortArray();
        Validate v = new Validate();
        System.out.println("========= Bubble Sort program =========");
        int a[] = new int[0];
        while (true) {
            s.printMenu();
            int choice = v.checkInputChoice();

            switch (choice) {
                case 1:
                    a = s.inputItemsofArray();
                    break;
                case 2:
                    s.sortArray(a, true);
                    break;
                case 3:
                    s.sortArray(a, false);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

}
