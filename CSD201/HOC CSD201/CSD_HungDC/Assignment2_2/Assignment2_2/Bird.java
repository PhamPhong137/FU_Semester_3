/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2_2;

/**
 *
 * @author dmngh
 */
public class Bird {
    String type;
    int rate;
    int wing;

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

    public Bird(String type, int rate, int wing) {
        this.type = type;
        this.rate = rate;
        this.wing = wing;
    }

    public Bird() {
    }

    @Override
    public String toString() {
        return "(" + type + "," + rate + "," + wing + ")";
    }
    
    
    
}
