/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptshop;

import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public int checkChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                return choice;

            } catch (NumberFormatException e) {
                System.err.print("Nhập lại lựa chọn của bạn: ");
            }
        }
    }

    public boolean isProductCodeValid(String code) {
        // The product code must be in the format <P000000> where 0 is a digit
        return code != null && code.matches("P\\d{6}");
    }

    public boolean isProductPriceValid(double price) {
        // Price must be greater than 0
        return price > 0;
    }

    public boolean isProductQuantityValid(int quantity) {
        // Quantity must be greater than 0
        return quantity > 0;
    }

    public String checkProductcode() {
        while (true) {
            System.out.print("Enter product code: ");
            String code = sc.nextLine();
            if (isProductCodeValid(code)) {
                return code;
            } else {
                System.err.println("Invalid product code.");
            }
        }
    }

    public double checkPrice() {
        while (true) {

            try {
                System.out.print("Enter product price: ");
                double price = Double.parseDouble(sc.nextLine());
                if (price > 0) {
                    return price;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid product price.");
            }

        }
    }

    public int checkQuantity() {
        while (true) {

            try {
                System.out.print("Enter product quantity: ");
                int quantity = Integer.parseInt(sc.nextLine());
                if (quantity > 0) {
                    return quantity;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid product price.");
            }
        }
    }

}
