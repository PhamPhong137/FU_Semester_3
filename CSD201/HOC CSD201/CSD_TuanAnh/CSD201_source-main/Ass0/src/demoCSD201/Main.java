/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoCSD201;

/**
 *
 * @author Admin MSI
 */
public class Main {
    public static void main(String[] args){
        MyList list = new MyList();
        list.addFirst(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(4);
        list.addLast(29);
        list.display();
        
        list.addIndext(9, 1);
        list.display();
    }
}
