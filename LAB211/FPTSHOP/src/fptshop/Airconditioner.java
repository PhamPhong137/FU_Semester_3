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
public class Airconditioner extends Product {

    private double power;

    public Airconditioner() {
    }

    public Airconditioner(double power) {
        this.power = power;
    }

    public Airconditioner(double power, String code, String name, String brand, double price, int quantity) {
        super(code, name, brand, price, quantity);
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Air-conditioner" + super.toString() + "Power=" + power;
    }

}
