/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

public class Run_length_Encoding {
    
    public static void encoding(String str){
        int n = str.length(); // n la do dai String can encoding
        for (int i = 0; i < n; i++) { // vong for de dem so luong cac ky tu can ma hoa
            int count = 1;    // Count occurrences of current character
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                // i chay toi n-1 va neu ky tu tai i bang voi ky tu tai i+1 thi count++
                count++;
                i++;
            }
            // Print character and its count
            System.out.print(count+" " +str.charAt(i) + "\t");
    }
}
    
    public static void main(String[] args){    
        String str1 = "555dqwddddd44444444";
        String str2= "aaaaafffgg";
        encoding(str1);
        System.out.println();
        encoding(str2);
        System.out.println();
    }
}
