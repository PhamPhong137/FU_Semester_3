/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PE_Fall1;

/**
 *
 * @author ADMIN
 */
public class Bee {
    String forest;
    int Rate;
    int Sound;

    public Bee() {
    }

    public Bee(String forest, int Rate, int Sound) {
        this.forest = forest;
        this.Rate = Rate;
        this.Sound = Sound;
    }

    public String getForest() {
        return forest;
    }

    public void setForest(String forest) {
        this.forest = forest;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int Rate) {
        this.Rate = Rate;
    }

    public int getSound() {
        return Sound;
    }

    public void setSound(int Sound) {
        this.Sound = Sound;
    }

    @Override
    public String toString() {
        return "("+forest+","+Rate+","+Sound+")"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
