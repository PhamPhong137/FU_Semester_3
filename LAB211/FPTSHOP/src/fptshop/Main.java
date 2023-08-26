/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptshop;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        Validate v = new Validate();
        // Add at least 9 products with all 3 types (you should replace these with actual instances of the product classes)
        // productManager.addProduct(...);
        // productManager.addProduct(...);
        // ...

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("1. Add a new product");
            System.out.println("2. Print the list of products");
            System.out.println("3. Print Smartphones in descending order of price");
            System.out.println("4. Print TVs in ascending order of price");
            System.out.println("5. Print Air-conditioners in descending order of price");
            System.out.println("6. Print highest unit price products for each type");
            System.out.println("7. Update product information");
            System.out.println("8. Delete product");
            System.out.println("9. Print the total amount of all products");
            System.out.println("10. Exit the program");
            System.out.print("Please enter your choice: ");

            int choice = v.checkChoice();

            switch (choice) {
                case 1:
                    pm.addProduct();
                    break;
                case 2:
                    pm.printAllProducts();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, please input 1 -> 10.");
            }
        }

        scanner.close();
    }
}
