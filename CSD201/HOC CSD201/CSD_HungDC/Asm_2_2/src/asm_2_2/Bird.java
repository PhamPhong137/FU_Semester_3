/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_2_2;

/**
 *
 * @author Admin
 */
public class Bird {
    private String type;
    private int rate;
    private int wing;

    public Bird() {
    }

    public Bird(String type, int rate, int wing) {
        this.type = type;
        this.rate = rate;
        this.wing = wing;
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
    
    @Override
    public String toString() {
        return "("+type+","+rate+","+wing+")";
    }
}
