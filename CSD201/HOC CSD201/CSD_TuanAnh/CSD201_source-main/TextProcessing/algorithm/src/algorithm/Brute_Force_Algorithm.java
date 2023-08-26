/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author Admin MSI
 */
public class Brute_Force_Algorithm {

  public static void search(char[] x, char[] y) {
    int m = x.length;// do dai Patten
    int n = y.length;// do dai text 
    System.out.println("Các vị trí xuất hiện trong văn bản của xâu mẫu là: ");
    for (int j = 0; j <= n - m; j++) { //Dich chuyen tren ban text
        System.out.println("buoc dich: "+j);
      for (int i = 0; i < m && x[i] == y[i + j]; i++) { // Dich chuyen tren patten
        if (i == m - 1) {
          System.out.println("Start of patten in text: "+j + " Ended of patten: " + (j+m));
        }
      }
    }
  }
  public static void main(String[] args) {
      System.out.println("GCATCGCAGAGAGTTATACAGTACG");
      System.out.println("GCAGAGAG");
    search("GCAGAGAG".toCharArray(), "GCATCGCAGAGAGTTATACAGTACG".toCharArray());
    
  }
    
}
