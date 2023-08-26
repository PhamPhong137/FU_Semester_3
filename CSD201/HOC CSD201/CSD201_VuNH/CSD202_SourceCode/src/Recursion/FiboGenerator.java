/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class FiboGenerator {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> hoenList = new ArrayList<>();
        hoenList.add(1);
        hoenList.add(2);
        hoenList.add(3);
        hoenList.add(4);
        hoenList.add(5);
        f1(hoenList);
        for (Integer a : hoenList)
            System.out.println(a);
    }

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void f1(ArrayList<Integer> a) {
        for (int i = a.size() - 1; i >= 0; i--) {
            if (isPrime(a.get(i))) {
                System.out.println("Yes");
                a.set(i, a.get(i) + 1);
                break;
            }
        }
    }

    /*
     * This method returns the c-th fibo number
     */
    static long fiboGenerator(int c) {
        if (c == 1) {
            return 0;
        }
        if (c == 2) {
            return 1;
        }
        return fiboGenerator(c - 1) + fiboGenerator(c - 2);
    }

    /*
     * This method returns the c! number
     */
    static long factorial(int c) {
        if (c <= 1) {
            return 1;
        }
        return c * factorial(c - 1);
    }

    static void displayFibo() {
        System.out.print("Enter a positive number: ");
        int c = inputPositiveNumber();
        System.out.print("Here is the sequence of the first " + c + " fibo numbers: ");
        for (int i = 1; i <= c; i++) {
            System.out.print(fiboGenerator(i) + ((i == c) ? "." : ", "));
        }
    }

    static void displayFactorial() {
        System.out.print("Enter a number: ");
        int c = sc.nextInt();
        System.out.println("c!= " + factorial(c));
    }

    static void displayMenu() {
        System.out.println("1. Test fibo");
        System.out.println("1. Test factorial");
        System.out.print("Choose 1 or 2: ");
        int opt = sc.nextInt();
        switch (opt) {
            case 1:
                displayFibo();
                break;
            case 2:
                displayFactorial();
                break;
            default:
                System.out.println("Unavailable option!");
        }
    }

    static int inputPositiveNumber() {
        int n;
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n > 0)
                    return n;
                System.out.println("You have to input a positive integer.");
            } catch (Exception e) {
                System.out.println("You have to input a positive integer.");
            }
        }
    }
}
