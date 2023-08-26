/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import static algorithm.Brute_Force_Algorithm.search;

/**
 *
 * @author Admin MSI
 */
public class KnuthMorrisPratt {
    
   public static void search(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;
        int d=1;
        System.out.print("Các vị trí xuất hiện trong văn bản của xâu mẫu là: ");
        for (int j = 0; j <= n - m; j++) {
            d=1;
            System.out.println("buoc dich: "+j);
            for (int i = 0; i < m; i++) {
                if (x[i] != y[i + j]) {
                    d=0;
                    j+=i;
                    i=m;
                }                
            }
            if(d==1) {
                System.out.println(j+" đến "+(j+m-1));
                j+=m-1;
            }
        }
    }
  public static void main(String[] args) {
    System.out.println("GCATCGCAGAGAGTTATACAGTACG");
      System.out.println("GCAGAGAG");
    search("GCAGAGAG".toCharArray(), "GCATCGCAGAGAGTTATACAGTACG".toCharArray());
  }
}
