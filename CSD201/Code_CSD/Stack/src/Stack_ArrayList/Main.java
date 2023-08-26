/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack_ArrayList;

/**
 *
 * @author PC-Phong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyStack_ArrayList ms = new MyStack_ArrayList();

        ms.push("1");
        ms.push("3");
        ms.push("9");
        ms.push("10");
        ms.push("11");
        ms.push("18");
        ms.push("16");
        ms.push("13");
        ms.pop();
//        boolean result = ms.isEmpty();
//        System.out.println("Is stack empty: " + result);       
        ms.display();
        
        //Search
        System.out.println("");
        int pos = ms.search("18");
        if(pos==-1){
            System.out.println("Not Found");
        }else{
            System.out.println("Position: "+pos);
        }
       
    }

}
