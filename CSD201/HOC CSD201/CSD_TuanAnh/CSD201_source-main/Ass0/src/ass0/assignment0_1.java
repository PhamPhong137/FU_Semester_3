/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass0;



/**
 *
 * @author Admin MSI
 */
public class assignment0_1 {
    public static void main(String[] args) {
        MyFeature List = new MyFeature();
        
        List.display();
        
        System.out.println("List before add: ");
        List.addLast(9);
        List.addLast(3);
        List.addLast(5);
        List.addLast(4);
        List.addLast(8);
        List.display();
        
        System.out.println("List after addLast: ");
        List.addLast(5);
        List.display();
        
        System.out.println("List after addFirst: ");
        List.addFirst(25);
        List.display();
        
        System.out.println("List after addIndex[5] with value 99: ");
        List.addIndext(99, 5);
        List.display();
        
        System.out.println("List after delete index[3]: ");
        List.deleteIndex(3);
        List.display();
        
        System.out.println("List after delete all prime number: ");
        List.delelePrimeNode();
        List.display();
    }
}
