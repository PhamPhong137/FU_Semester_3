/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_3.Q1;

/**
 *
 * @author TLC
 */
public class Bee {
    String forest;
    int rate,sound;

    public Bee(String forest, int rate, int sound) {
        this.forest = forest;
        this.rate = rate;
        this.sound = sound;
    }

    public Bee() {
    }

    public String getForest() {
        return forest;
    }

    public void setForest(String forest) {
        this.forest = forest;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "("+forest+","+rate+","+sound+")";
    }
    
}
