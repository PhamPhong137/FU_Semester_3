/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptshop;

/**
 *
 * @author PC-Phong
 */
public class TV extends Product {

    private double size;

    public TV() {
    }

    public TV(double size) {
        this.size = size;
    }

    public TV(double size, String code, String name, String brand, double price, int quantity) {
        super(code, name, brand, price, quantity);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "TV " + super.toString() + "size=" + size;
    }

}
