/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg42loc.chuvidientich;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validate v = new Validate();
        System.out.println("=====Calculator Shape Program=====");

        // Rectangle
        System.out.print("Enter the width of the rectangle: ");
        double width = v.inputDouble();
        double length;
        while (true) {
            System.out.print("Enter the length of the rectangle: ");
            length = v.inputDouble();
            if (v.checkRectangle(width, length)) {
                break;
            }
        }
        Rectangle rectangle = new Rectangle(width, length);

        // Circle
        System.out.print("Enter the radius of the circle: ");
        double radius = v.inputDouble();
        Circle circle = new Circle(radius);

        // Triangle
        double sideA, sideB, sideC;
        while (true) {
            System.out.print("Enter the length of side A of the triangle: ");
            sideA = v.inputDouble();
            System.out.print("Enter the length of side B of the triangle: ");
            sideB = v.inputDouble();
            System.out.print("Enter the length of side C of the triangle: ");
            sideC = v.inputDouble();
            if (v.checkTriangle(sideA, sideB, sideC)) {
                break;
            }
            System.out.println("Input length of side again");
        }

        Triangle triangle = new Triangle(sideA, sideB, sideC);

        Shape[] shape = {rectangle, circle, triangle};
        for (int i = 0; i < 3; i++) {
            shape[i].printResult();
        }
    }
}
