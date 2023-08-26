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
public class Smartphone extends Product {

    private int ram;
    private String cpu;
    private double size;

    public Smartphone() {
    }

    public Smartphone(int ram, String cpu, double size) {
        this.ram = ram;
        this.cpu = cpu;
        this.size = size;
    }

    public Smartphone(int ram, String cpu, double size, String code, String name, String brand, double price, int quantity) {
        super(code, name, brand, price, quantity);
        this.ram = ram;
        this.cpu = cpu;
        this.size = size;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Smartphone "+super.toString() + "Ram=" + ram + "CPU= " + cpu + "Size=" + size;
    }

}
