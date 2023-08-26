package Model;

import java.util.Scanner;

public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static int getInt(String mess, int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        while (true) {
            try {
                System.out.print(mess);
                int n = Integer.parseInt(sc.nextLine());
                if (min <= n && n <= max) {
                    return n;
                }
                System.err.println("PLEASE INPUT A NUMBER IN RANGE " + min + " -> " + max);
            } catch (NumberFormatException ex) {
                System.err.println("WRONG FORMAT");
            }
        }
    }
    
    public static String getString(String mess){
        while (true) {            
            System.out.print(mess);
            String s = sc.nextLine();
            if(!s.isEmpty()){
                return s;                
            }
            System.err.println("EMPTY STRING IS NOT ALLOWED");
        }
    }
    
    public static boolean getYN(String mess){
        while (true) {
            System.out.println(mess);
            String s = sc.nextLine();
            if(s.equalsIgnoreCase("Y")){
                return true;
            }else if(s.equalsIgnoreCase("N")){
                return false;
            }
            System.err.println("Please input only Y/N");
            
        }
    }
}
