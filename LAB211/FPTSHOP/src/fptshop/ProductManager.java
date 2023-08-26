/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class ProductManager {

    Scanner scanner = new Scanner(System.in);
    Validate v = new Validate();

    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct() {

        System.out.println("Select product type:");
        System.out.println("1. Smartphone");
        System.out.println("2. TV");
        System.out.println("3. Air-conditioner");
        System.out.print("Enter your choice: ");
        int productType = Integer.parseInt(scanner.nextLine());

        Product newProduct = null;

        if (productType >= 1 && productType <= 3) {
            String code = v.checkProductcode();

            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter product brand: ");
            String brand = scanner.nextLine();

            double price = v.checkPrice();

            int quantity = v.checkQuantity();

            switch (productType) {
                case 1: // Smartphone
                    System.out.print("Enter smartphone RAM (GB): ");
                    int ram = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter smartphone CPU: ");
                    String cpu = scanner.nextLine();

                    System.out.print("Enter smartphone size (inches): ");
                    double size = Double.parseDouble(scanner.nextLine());

                    newProduct = new Smartphone(ram, cpu, size, code, name, brand, price, quantity);
                    break;

                case 2: // TV
                    System.out.print("Enter TV size (inches): ");
                    double tvSize = Double.parseDouble(scanner.nextLine());

                    newProduct = new TV(tvSize, code, name, brand, price, quantity);
                    break;

                case 3: // Air-conditioner
                    System.out.print("Enter air-conditioner power (W): ");
                    double power = Double.parseDouble(scanner.nextLine());

                    newProduct = new Airconditioner(power, code, name, brand, price, quantity);
                    break;
            }

            if (newProduct != null) {
                products.add(newProduct);
                System.out.println("Product added successfully.");
            }
        } else {
            System.out.println("Invalid product type.");
        }

    }

    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("List of products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

}
