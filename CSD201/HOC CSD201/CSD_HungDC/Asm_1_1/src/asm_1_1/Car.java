/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_1_1;

/**
 *
 * @author Admin
 */
public class Car {

    /**
     * @param args the command line arguments
     */
        String Name;
        double Price;
        Car next;
        public Car(){
            
        }

    public Car(String Name, double Price, Car next) {
        this.Name = Name;
        this.Price = Price;
        this.next = next;
    }
    public Car(String Name, double Price){
        this.Name=Name;
        this.Price=Price;
        this.next=null;
    }    
    @Override
    public String toString() {
        return "(" + Name + ","+Price+")";
    }
    
}
