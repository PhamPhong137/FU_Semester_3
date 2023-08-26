/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_2;

public class Bird {
    String type;
    int rate;
    int wing;
    Bird next;

    public Bird() {
    }

    public Bird(String type, int rate, int wing, Bird next) {
        this.type = type;
        this.rate = rate;
        this.wing = wing;
        this.next = next;
    }
    
    public Bird(String type, int rate, int wing) {
        this.type = type;
        this.rate = rate;
        this.wing = wing;
        next = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getWing() {
        return wing;
    }

    public void setWing(int wing) {
        this.wing = wing;
    }

    public Bird getNext() {
        return next;
    }

    public void setNext(Bird next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "("+type+","+rate+","+wing+")"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
