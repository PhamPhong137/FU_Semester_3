/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author ADMIN
 */
public class Castor {
    String place;
    int depth;
    int type;

    public Castor() {
    }

    public Castor(String place, int depth, int type) {
        this.place = place;
        this.depth = depth;
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "("+place+","+depth+","+type+")"; //To change body of generated methods, choose Tools | Templates.
    }
}
