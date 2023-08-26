/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg72loc.equation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author PC-Phong
 */
public class Calculate {

    Validate v = new Validate();

    public void inputMenu() {
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.println("Please choice one option: ");
    }

    public boolean isEven(float number) {
        return number % 2 == 0;
    }

    public boolean isOdd(float number) {
        return number % 2 != 0;
    }

    public boolean isPerfectSquare(float number) {
        float squareRoot = (float) Math.sqrt(number);
        return squareRoot == Math.floor(squareRoot);
    }

    public List<Float> calculateEquation(float a, float b) {
        if (a == 0 && b != 0) {
            return null; // no solution
        }
        if (a == 0 && b == 0) {
            return new ArrayList<>(); // infinite solutions
        }
        List<Float> solutions = new ArrayList<>();
        float solution = -b / a;
        solutions.add(solution);
        return solutions;
    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        float denta = b * b - 4 * a * c;

        if (denta < 0) {
            // No real solutions
            return null;
        } else if (denta == 0) {
            // One real solution
            List<Float> solution = new ArrayList<>();
            solution.add(-b / (2 * a));
            solution.add(-b / (2 * a));
            return solution;
        } else {
            // Two real solutions
            List<Float> solutions = new ArrayList<>();
            solutions.add((-b + (float) Math.sqrt(denta)) / (2 * a));
            solutions.add((-b - (float) Math.sqrt(denta)) / (2 * a));
            return solutions;
        }
    }

    public void display(float... numbers) {
        String a = "Number is Odd: ";
        String b = "Number is Even: ";
        String c = "Number is Perfect Square: ";

//        for (float number : numbers) {
//            if (isOdd(number)) {
//                a = a + String.valueOf(number) + ", ";
//            }
//            if (isEven(number)) {
//                b = b + String.valueOf(number) + ", ";
//            }
//            if (isPerfectSquare(number)) {
//                c = c + String.valueOf(number) + ", ";
//            }
//        }
        Set<Float> uniqueNumbers = new HashSet<>();
                Set<Float> uniqueNumbers1 = new HashSet<>();

        for (float number : numbers) {
            if (isOdd(number) && uniqueNumbers.add(number)) {
                a = a + String.valueOf(number) + ", ";
            }
            if (isEven(number) && uniqueNumbers.add(number)) {
                b = b + String.valueOf(number) + ", ";
            }
            if (isPerfectSquare(number) && uniqueNumbers1.add(number)) {
                c = c + String.valueOf(number) + ", ";
            }
        }

        System.out.println(a.substring(0, a.length() - 2));
        System.out.println(b.substring(0, b.length() - 2));
        System.out.println(c.substring(0, c.length() - 2));

    }

    public void calculateSuperlativeEquation() {
        System.out.println("----- Calculate Equation -----");
        float a = v.checkFloat("Enter A: ");
        float b = v.checkFloat("Enter B: ");
        List<Float> solution = calculateEquation(a, b);
        if (solution == null) {
            System.out.println("No solution exists.");
            return;
        } else if (solution.isEmpty()) {
            System.out.println("Infinite solutions.");
            return;
        } else {
            System.out.println("Solution: " + solution.get(0));
        }
        display(a, b, solution.get(0));
    }

    public void calculateQuadraticEquation() {
        System.out.println("----- Calculate Quadratic Equation -----");
        float a = v.checkFloat("Enter A: ");
        float b = v.checkFloat("Enter B: ");
        float c = v.checkFloat("Enter C: ");
        List<Float> solutions = calculateQuadraticEquation(a, b, c);
        if (solutions == null) {
            System.out.println("No solution exists.");
            return;
        } else if (solutions.isEmpty()) {
            System.out.println("Infinite solutions.");
            return;
        } else {
            System.out.println("Solution: x1 = " + solutions.get(0) + " and x2 = " + solutions.get(1));
        }
        display(a, b, c, solutions.get(0), solutions.get(1));
    }
}
